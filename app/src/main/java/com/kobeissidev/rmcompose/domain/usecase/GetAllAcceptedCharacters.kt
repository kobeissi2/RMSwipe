package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.ACCEPT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetAllAcceptedCharacters(private val repository: RMRepository) {
    operator fun invoke() = flow {
        emit(
            repository.dao.getAllSwipeResult(ACCEPT)
                .map { it.name }
                .sorted()
        )
    }.flowOn((Dispatchers.IO))
}