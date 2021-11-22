package com.kobeissidev.rmswipe.data.model.character

import android.os.Parcelable
import com.kpstv.bindings.AutoGenerateConverter
import com.kpstv.bindings.ConverterType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@AutoGenerateConverter(using = ConverterType.MOSHI)
@Parcelize
data class Origin(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "url")
    val url: String = ""
) : Parcelable