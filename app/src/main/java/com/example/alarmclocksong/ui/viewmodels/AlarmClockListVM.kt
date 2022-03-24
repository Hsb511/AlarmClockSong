package com.example.alarmclocksong.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclocksong.ui.extensions.getNextFreeId
import com.example.alarmclocksong.ui.viewobjects.AlarmClockVO
import kotlinx.coroutines.launch

class AlarmClockListVM : ViewModel() {
    val alarmClocks = mutableStateListOf<AlarmClockVO>()

    init {
        viewModelScope.launch {
            alarmClocks.addAll(
                mutableListOf(
                    AlarmClockVO(id = 1),
                    AlarmClockVO(id = 2, state = false),
                    AlarmClockVO(id = 3, time = "23:23")
                )
            )
        }
    }

    fun addAlarmClock() {
        alarmClocks.add(AlarmClockVO(alarmClocks.getNextFreeId()))
    }

    fun removeAlarmClock(alarmClockVO: AlarmClockVO) {
        alarmClocks.remove(alarmClockVO)
    }

    fun updateAlarmClockTime(alarmClockVO: AlarmClockVO, time: String) {

    }

}