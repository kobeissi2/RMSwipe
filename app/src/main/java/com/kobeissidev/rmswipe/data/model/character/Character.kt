package com.kobeissidev.rmswipe.data.model.character

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.NA
import com.kpstv.bindings.AutoGenerateConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity(tableName = "character")
@AutoGenerateConverter(using = ConverterType.MOSHI)
@JsonClass(generateAdapter = true)
@Parcelize
data class Character(
    @Json(name = "created")
    var created: String = "",
    @Json(name = "episode")
    var episode: List<String> = listOf(),
    @Json(name = "gender")
    var gender: String = "",
    @Json(name = "id")
    @PrimaryKey var id: String = "0",
    @Json(name = "image")
    var image: String = "",
    @Json(name = "location")
    var location: Location = Location(),
    @Json(name = "name")
    var name: String = "",
    @Json(name = "origin")
    var origin: Origin = Origin(),
    @Json(name = "species")
    var species: String = "",
    @Json(name = "status")
    var status: String = "",
    @Json(name = "type")
    var type: String = "",
    @Json(name = "url")
    var url: String = "",
    var swipeResult: SwipeResult = NA
) : Parcelable