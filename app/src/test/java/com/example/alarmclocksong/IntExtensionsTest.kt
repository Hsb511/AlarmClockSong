package com.example.alarmclocksong

import com.example.alarmclocksong.ui.extensions.toReadableTime
import org.junit.Test

class IntExtensionsTest {
    @Test
    fun `null to readable time is 00`() {
        assert(null.toReadableTime() == "00")
    }

    @Test
    fun `0 to readable time is 00`() {
        assert(0.toReadableTime() == "00")
    }

    @Test
    fun `23 to readable time is 23`() {
        assert(23.toReadableTime() == "23")
    }
    @Test
    fun `9 hours and 30 minutes to readable time is 09 30`() {
        assert("${9.toReadableTime()}:${30.toReadableTime()}" == "09:30")
    }

}