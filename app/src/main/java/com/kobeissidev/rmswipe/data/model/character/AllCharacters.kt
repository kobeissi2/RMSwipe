package com.kobeissidev.rmswipe.data.model.character

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class AllCharacters(
    @Json(name = "info")
    val info: Info = Info(),
    @Json(name = "results")
    val results: List<Result> = listOf()
) : Parcelable