package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateCharacter(private val repository: RMRepository) {
    suspend operator fun invoke(character: Character, result: SwipeResult) =
        withContext(Dispatchers.IO) { repository.dao.updateCharacter(character.copy(swipeResult = result)) }
}