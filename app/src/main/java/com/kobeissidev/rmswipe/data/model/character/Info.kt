package com.kobeissidev.rmswipe.data.model.character

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Info(
    @Json(name = "count")
    val count: Int = 0,
    @Json(name = "next")
    val next: String? = null,
    @Json(name = "pages")
    val pages: Int = 0,
    @Json(name = "prev")
    val prev: String? = null
) : Parcelable