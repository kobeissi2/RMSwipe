package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.util.getResult
import com.kobeissidev.rmswipe.util.suspendOnSuccessState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

class GetNextCharacters(
    private val repository: RMRepository,
    private val getCharacterCount: GetCharacterCount,
    private val getNextRandomInt: GetNextRandomInt
) {

    suspend operator fun invoke() = with(repository) {
        val results = mutableListOf<Character>()

        withContext(Dispatchers.IO) {
            characterFlow.emit(listOf())
            (StartIndex..LastIndex).map {
                async(Dispatchers.IO) {
                    getResult {
                        rmApiService.getCharacter(getNextRandomInt(getCharacterCount.totalSize))
                    }.suspendOnSuccessState { character ->
                        dao.insert(character)
                        results.add(character)
                    }
                }
            }.awaitAll()
            characterFlow.emit(results)
        }
    }

    private companion object {
        const val StartIndex = 1
        const val LastIndex = 10
    }
}