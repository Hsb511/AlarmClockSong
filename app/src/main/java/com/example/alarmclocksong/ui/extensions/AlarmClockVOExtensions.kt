package com.example.alarmclocksong.ui.extensions

import com.example.alarmclocksong.data.models.AlarmClockDO
import com.example.alarmclocksong.ui.viewobjects.AlarmClockVO

fun List<AlarmClockVO>.getNextFreeId() = if (this.isEmpty()) { 1 } else { 1 + this.maxOf { it.id } }

fun List<AlarmClockVO>.toDataObjects() = this.map {
    AlarmClockDO(
        id = it.id,
        time = it.time,
        state = it.isActive
    )
}