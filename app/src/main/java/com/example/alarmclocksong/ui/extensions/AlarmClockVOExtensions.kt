package com.example.alarmclocksong.ui.extensions

import com.example.alarmclocksong.ui.viewobjects.AlarmClockVO

fun List<AlarmClockVO>.getNextFreeId() = if (this.isEmpty()) { 1 } else { 1 + this.maxOf { it.id } }