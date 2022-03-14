package com.example.alarmclocksong.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclocksong.domain.model.AlarmClockVO
import kotlinx.coroutines.launch

class AlarmClockListVM : ViewModel() {
    val alarmClocks: MutableLiveData<List<AlarmClockVO>> = MutableLiveData(listOf())

    init {
        viewModelScope.launch {
            alarmClocks.postValue(
                listOf(
                    AlarmClockVO("00:00", true),
                    AlarmClockVO("00:00", false),
                    AlarmClockVO("23:23", true)
                )
            )
        }
    }
}