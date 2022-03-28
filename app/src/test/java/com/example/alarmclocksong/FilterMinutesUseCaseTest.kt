package com.example.alarmclocksong

import androidx.compose.ui.text.input.TextFieldValue
import com.example.alarmclocksong.domain.usecases.FilterMinutesUseCase
import org.junit.Test

class FilterMinutesUseCaseTest {
    @Test
    fun `non-numbered minutes returns empty`() {
        assert(FilterMinutesUseCase.execute(TextFieldValue("a")) == "")
    }

    @Test
    fun `minus one minute returns empty`() {
        assert(FilterMinutesUseCase.execute(TextFieldValue("-1")) == "")
    }

    @Test
    fun `zero minute returns 0`() {
        assert(FilterMinutesUseCase.execute(TextFieldValue("0")) == "0")
    }

    @Test
    fun `two minutes returns 2`() {
        assert(FilterMinutesUseCase.execute(TextFieldValue("2")) == "2")
    }

    @Test
    fun `twenty three minutes returns 23`() {
        assert(FilterMinutesUseCase.execute(TextFieldValue("23")) == "23")
    }

    @Test
    fun `sixty minutes returns 59`() {
        assert(FilterMinutesUseCase.execute(TextFieldValue("60")) == "59")
    }
}