package com.example.alarmclocksong.ui.extensions

import androidx.compose.ui.graphics.Color

fun Boolean.switchColors(enabledColor: Color, disabledColor: Color) =
    if (this) {
        enabledColor
    } else {
        disabledColor
    }