package com.example.alarmclocksong.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclocksong.domain.usecases.FilterHoursUseCase
import com.example.alarmclocksong.domain.usecases.FilterMinutesUseCase
import com.example.alarmclocksong.ui.extensions.getNextFreeId
import com.example.alarmclocksong.ui.extensions.toReadableTime
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
        val id = alarmClocks.getNextFreeId()
        Log.d("AlarmClockListVM", "Creating a new alarmClock with id: $id")
        alarmClocks.add(AlarmClockVO(id))
    }

    fun removeAlarmClock(alarmClockVO: AlarmClockVO) {
        Log.d("AlarmClockListVM", "Removing the alarm clock with id: ${alarmClockVO.id}")
        alarmClocks.remove(alarmClockVO)
    }

    fun updateAlarmClockTime(id: Int, hours: Int?, minutes: Int?) {
        val time = "${hours.toReadableTime()}:${minutes.toReadableTime()}"
        Log.d("AlarmClockListVM", "New time : $time set for alarm clock with id: $id")
        alarmClocks.find { it.id == id }?.let { it.time = time }
    }

    fun onHoursChanged(hours: TextFieldValue) = FilterHoursUseCase.execute(hours = hours)

    fun onMinutesChanged(minutes: TextFieldValue) = FilterMinutesUseCase.execute(minutes = minutes)

    fun updateAlarmClockState(id: Int, state: Boolean) {

    }
}