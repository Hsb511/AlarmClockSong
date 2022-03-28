package com.example.alarmclocksong

import androidx.compose.ui.text.input.TextFieldValue
import com.example.alarmclocksong.domain.usecases.FilterHoursUseCase
import com.example.alarmclocksong.domain.usecases.FilterMinutesUseCase
import org.junit.Test

class FilterHoursUseCaseTest {
    @Test
    fun `non-numbered hours returns empty`() {
        assert(FilterHoursUseCase.execute(TextFieldValue("a")) == "")
    }

    @Test
    fun `minus one minute returns empty`() {
        assert(FilterMinutesUseCase.execute(TextFieldValue("-1")) == "")
    }

    @Test
    fun `zero hours returns 0`() {
        assert(FilterHoursUseCase.execute(TextFieldValue("0")) == "0")
    }

    @Test
    fun `two hours returns 2`() {
        assert(FilterHoursUseCase.execute(TextFieldValue("2")) == "2")
    }

    @Test
    fun `twenty four hours returns 23`() {
        assert(FilterHoursUseCase.execute(TextFieldValue("24")) == "23")
    }
}