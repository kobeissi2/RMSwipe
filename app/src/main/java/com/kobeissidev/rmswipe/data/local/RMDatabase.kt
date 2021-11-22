package com.kobeissidev.rmswipe.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kobeissidev.rmswipe.data.model.character.Character

@Database(entities = [Character::class], version = 1)
@TypeConverters(
    com.kobeissidev.rmswipe.data.model.character.CharacterConverter::class,
    com.kobeissidev.rmswipe.data.model.character.LocationConverter::class,
    com.kobeissidev.rmswipe.data.model.character.OriginConverter::class,
    com.kobeissidev.rmswipe.data.local.converters.StringListConverter::class
)
abstract class RMDatabase: RoomDatabase() {
    abstract fun dao() : RMDao
}