package com.kobeissidev.rmswipe.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun RMSwipeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = darkColors(
            primary = RMGreen,
            onPrimary = Color.Black,
            primaryVariant = RMGreen,
            secondary = RMGreen,
            background = RMBlue,
            surface = RMGreen
        ),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}