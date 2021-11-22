package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.REJECT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetAllRejectedCharacters(private val repository: RMRepository) {
    operator fun invoke() = flow {
        emit(
            repository.dao.getAllSwipeResult(REJECT)
                .map { it.name }
                .sorted()
        )
    }.flowOn((Dispatchers.IO))
}