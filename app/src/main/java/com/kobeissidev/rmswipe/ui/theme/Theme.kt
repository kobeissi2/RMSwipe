package com.kobeissidev.rmswipe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion

private val DarkColorPalette = darkColors(
    primary = RMGreen,
    onPrimary = Color.Black,
    primaryVariant = RMGreen,
    secondary = RMGreen,
    background = RMBlue,
    surface = RMGreen
)

private val LightColorPalette = lightColors(
    primary = RMGreen,
    onPrimary = Color.Black,
    primaryVariant = RMGreen,
    secondary = RMGreen,
    background = RMBlue,
    surface = RMGreen
)

@Composable
fun RMSwipeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}