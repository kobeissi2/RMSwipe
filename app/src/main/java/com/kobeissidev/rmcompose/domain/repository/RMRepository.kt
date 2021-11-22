package com.kobeissidev.rmswipe.domain.repository

import com.kobeissidev.rmswipe.data.local.RMDao
import com.kobeissidev.rmswipe.data.local.RMDatabase
import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.data.remote.RMApiService
import kotlinx.coroutines.flow.MutableStateFlow

class RMRepository(
    private val database: RMDatabase,
    val rmApiService: RMApiService,
    val dao: RMDao = database.dao()
) {
    val characterFlow = MutableStateFlow(listOf<Character>())
}