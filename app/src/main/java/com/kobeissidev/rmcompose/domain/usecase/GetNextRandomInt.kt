package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import kotlin.random.Random

class GetNextRandomInt(private val repository: RMRepository) {

    suspend operator fun invoke(totalSize: Int) = with(repository.dao) {
        var randomInt = Random.nextInt(1, totalSize + 1).toString()
        var character = getCharacter(randomInt)

        while (character != null && character.swipeResult != SwipeResult.NA && getCharacterCount() <= totalSize) {
            randomInt = Random.nextInt(1, totalSize + 1).toString()
            character = getCharacter(randomInt)
        }
        randomInt
    }
}