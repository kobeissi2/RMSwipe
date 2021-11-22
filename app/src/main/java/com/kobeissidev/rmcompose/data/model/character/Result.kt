package com.kobeissidev.rmswipe.data.model.character

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Result(
    @Json(name = "created")
    val created: String = "",
    @Json(name = "episode")
    val episode: List<String> = listOf(),
    @Json(name = "gender")
    val gender: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "image")
    val image: String = "",
    @Json(name = "location")
    val location: Location = Location(),
    @Json(name = "name")
    val name: String = "",
    @Json(name = "origin")
    val origin: Origin = Origin(),
    @Json(name = "species")
    val species: String = "",
    @Json(name = "status")
    val status: String = "",
    @Json(name = "type")
    val type: String = "",
    @Json(name = "url")
    val url: String = ""
) : Parcelable