package com.example.alarmclocksong.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclocksong.domain.model.AlarmClockVO
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

    fun addNewAlarmClock() {
        Log.d(
            "AlarmClockListVM",
            "Displaying a new alarm clock, ${alarmClocks.size} alarm clock(s) displayed"
        )
        alarmClocks.add(AlarmClockVO())
    }
}