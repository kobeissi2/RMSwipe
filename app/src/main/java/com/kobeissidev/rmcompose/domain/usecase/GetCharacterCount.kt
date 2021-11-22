package com.kobeissidev.rmswipe.domain.usecase

import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.util.getResult
import com.kobeissidev.rmswipe.util.onSuccessStateChanged

class GetCharacterCount(private val repository: RMRepository) {

    @Volatile
    var totalSize = 0

    suspend operator fun invoke(onEmitted: () -> Unit) = getResult { repository.rmApiService.getAllCharacters() }
        .onSuccessStateChanged {
            totalSize = it.info.count
            onEmitted()
        }
}