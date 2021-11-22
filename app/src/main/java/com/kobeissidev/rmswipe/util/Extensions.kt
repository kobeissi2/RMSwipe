package com.kobeissidev.rmswipe.util

import java.util.*

val String.capitalized
    get() = replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else it.toString()
    }