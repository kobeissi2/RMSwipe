package com.kobeissidev.rmswipe.data.local.converters

import androidx.room.TypeConverter

object StringListConverter {

    private const val Delimiter = ","

    @TypeConverter
    fun fromString(stringListString: String) = stringListString.split(Delimiter).map { it }

    @TypeConverter
    fun toString(stringList: List<String>) = stringList.joinToString(separator = Delimiter)
}