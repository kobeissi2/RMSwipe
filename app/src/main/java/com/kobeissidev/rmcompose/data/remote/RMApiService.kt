package com.kobeissidev.rmswipe.data.remote

import com.kobeissidev.rmswipe.data.model.character.AllCharacters
import com.kobeissidev.rmswipe.data.model.character.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RMApiService {

    @GET("character")
    suspend fun getAllCharacters(): Response<AllCharacters>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): Response<Character>
}