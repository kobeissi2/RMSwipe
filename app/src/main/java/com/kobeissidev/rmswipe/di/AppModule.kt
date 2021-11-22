package com.kobeissidev.rmswipe.di

import com.kobeissidev.rmswipe.data.local.RMDatabase
import com.kobeissidev.rmswipe.data.remote.RMApiService
import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRMRepository(
        rmDatabase: RMDatabase,
        RMApiService: RMApiService
    ) = RMRepository(rmDatabase, RMApiService)

    @Provides
    @Singleton
    fun provideGetAcceptedCountUseCase(repository: RMRepository) = GetAcceptedCount(repository)

    @Provides
    @Singleton
    fun provideGetAllAcceptedCharactersUseCase(repository: RMRepository) = GetAllAcceptedCharacters(repository)

    @Provides
    @Singleton
    fun provideGetAllRejectedCharactersUseCase(repository: RMRepository) = GetAllRejectedCharacters(repository)

    @Provides
    @Singleton
    fun provideGetCharacterCountUseCase(repository: RMRepository) = GetCharacterCount(repository)

    @Provides
    @Singleton
    fun provideGetNextCharactersUseCase(
        repository: RMRepository,
        getCharacterCount: GetCharacterCount,
        getNextRandomInt: GetNextRandomInt
    ) = GetNextCharacters(repository, getCharacterCount, getNextRandomInt)

    @Provides
    @Singleton
    fun provideGetNextRandomIntUseCase(repository: RMRepository) = GetNextRandomInt(repository)

    @Provides
    @Singleton
    fun provideGetRejectedCountUseCase(repository: RMRepository) = GetRejectedCount(repository)

    @Provides
    @Singleton
    fun provideUpdateCharacterUseCase(repository: RMRepository) = UpdateCharacter(repository)
}