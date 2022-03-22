package com.example.alarmclocksong.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclocksong.ui.viewobjects.AlarmClockVO
import kotlinx.coroutines.launch

class AlarmClockListVM : ViewModel() {
    val alarmClocks = mutableStateListOf<AlarmClockVO>()

    init {
        viewModelScope.launch {
            alarmClocks.addAll(
                mutableListOf(
                    AlarmClockVO(),
                    AlarmClockVO(state = false),
                    AlarmClockVO(time = "23:23")
                )
            )
        }
    }

    fun addAlarmClock() {
        alarmClocks.add(AlarmClockVO())
    }

    fun removeAlarmClock(alarmClockVO: AlarmClockVO) {
        alarmClocks.remove(alarmClockVO)
    }

}