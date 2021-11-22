package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.ACCEPT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class GetAcceptedCount(private val repository: RMRepository) {
    operator fun invoke() = repository.dao.getAllSwipeResultCount(ACCEPT).flowOn(Dispatchers.IO)
}