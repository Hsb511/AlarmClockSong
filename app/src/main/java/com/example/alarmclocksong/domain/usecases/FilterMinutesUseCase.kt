package com.example.alarmclocksong.domain.usecases

import androidx.compose.ui.text.input.TextFieldValue

class FilterMinutesUseCase {
    companion object {
        fun execute(minutes: TextFieldValue) = minutes.text.toIntOrNull()?.let {
            when {
                it < 0 -> ""
                it >= 59 -> "59"
                else -> it.toString()
            }
        } ?: ""
    }
}