package com.example.alarmclocksong

import com.example.alarmclocksong.ui.extensions.getHoursFromTime
import com.example.alarmclocksong.ui.extensions.getMinutesFromTime
import org.junit.Test

class StringExtensionsTest {
    @Test
    fun `retrieve 0 hours from 00 00`() {
        assert("00:00".getHoursFromTime() == 0)
    }

    @Test
    fun `retrieve 23 hours from 23 30`() {
        assert("23:30".getHoursFromTime() == 23)
    }

    @Test
    fun `retrieve null hours from AA BB`() {
        assert("AA:BB".getHoursFromTime() == null)
    }

    @Test
    fun `retrieve 0 minutes from 00 00`() {
        assert("00:00".getMinutesFromTime() == 0)
    }

    @Test
    fun `retrieve 30 minutes from 23 30`() {
        assert("23:30".getMinutesFromTime() == 30)
    }

    @Test
    fun `retrieve null minutes from AA BB`() {
        assert("AA:BB".getMinutesFromTime() == null)
    }
}