package com.kobeissidev.rmswipe.data.local

import androidx.room.*
import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import kotlinx.coroutines.flow.Flow

@Dao
interface RMDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: Character)

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun getCharacter(id: String): Character?

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCharacter(character: Character)

    @Query("SELECT * FROM character WHERE swipeResult = (:swipeResult)")
    fun getAllSwipeResult(swipeResult: SwipeResult): List<Character>

    @Query("SELECT COUNT(id) FROM character WHERE swipeResult = (:swipeResult)")
    fun getAllSwipeResultCount(swipeResult: SwipeResult): Flow<Int>

    @Query("SELECT COUNT(id) FROM character")
    suspend fun getCharacterCount(): Int

    @Delete
    suspend fun deleteCharacter(character: Character)
}