package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.alarmclocksong.R
import com.example.alarmclocksong.ui.components.ActionButton
import com.example.alarmclocksong.ui.components.TimeTextField
import com.example.alarmclocksong.ui.viewmodels.AlarmClockListVM

@Composable
fun TimePicker(
    navController: NavHostController,
    id: Int, oldHours: Int?, oldMinutes: Int?,
    alarmClockListVm: AlarmClockListVM = AlarmClockListVM()
) =
    TimePicker(
        oldHours = oldHours,
        onHoursChanged = { hours -> alarmClockListVm.onHoursChanged(hours) },
        oldMinutes = oldMinutes,
        onMinutesChanged = { minutes -> alarmClockListVm.onMinutesChanged(minutes) },
        onTimeSaved = { time: String ->
            run {
                alarmClockListVm.updateAlarmClockTime(id, time)
                navController.navigate("alarmClockList")
            }
        })

@Composable
private fun TimePicker(
    oldHours: Int?, onHoursChanged: (hours: TextFieldValue) -> String,
    oldMinutes: Int?, onMinutesChanged: (minutes: TextFieldValue) -> String,
    onTimeSaved: (time: String) -> Unit
) {
    val hours = remember { mutableStateOf(TextFieldValue(oldHours.toString())) }
    val minutes = remember { mutableStateOf(TextFieldValue(oldMinutes.toString())) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                TimeTextField(hours, onHoursChanged)
            }
            Column {
                Text(text = ":", fontSize = 24.sp, modifier = Modifier.padding(8.dp))
            }
            Column(modifier = Modifier.weight(1f)) {
                TimeTextField(minutes, onMinutesChanged)
            }
        }

        ActionButton(
            text = stringResource(id = R.string.save_button),
            onClick = { onTimeSaved("${hours.value.text}:${minutes.value.text}") }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CustomTimePickerPreview() {
    TimePicker(23, { "" }, 23, { "" }, {})
}