package com.example.alarmclocksong.domain.usecases

import androidx.compose.ui.text.input.TextFieldValue

class FilterHoursUseCase {
    companion object {
        fun execute(hours: TextFieldValue) = hours.text.toIntOrNull()?.let {
            when {
                it < 0 -> ""
                it >= 23 -> "23"
                else -> it.toString()
            }
        } ?: ""
    }
}