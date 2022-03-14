package com.example.alarmclocksong.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColorPalette =
    darkColors(primary = Cornsilk, background = DarkGrey, onBackground = DarkerGrey)

private val LightColorPalette =
    lightColors(primary = OxfordBlue, background = Cornsilk, onBackground = LightGrey)

@Composable
fun ACSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors =
        if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

    MaterialTheme(colors = colors, typography = Typography, shapes = Shapes, content = content)
}