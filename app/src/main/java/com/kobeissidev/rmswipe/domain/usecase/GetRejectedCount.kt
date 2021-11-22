package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.REJECT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class GetRejectedCount(private val repository: RMRepository) {
    operator fun invoke() = repository.dao.getAllSwipeResultCount(REJECT).flowOn(Dispatchers.IO)
}