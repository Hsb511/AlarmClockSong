package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.alarmclocksong.R
import com.example.alarmclocksong.ui.viewmodels.AlarmClockListVM

@Composable
fun TimePicker(
    navController: NavHostController,
    id: Int, oldHours: Int?, oldMinutes: Int?,
    alarmClockListVm: AlarmClockListVM = AlarmClockListVM()
) =
    TimePicker(
        oldHours = oldHours,
        onHoursChanged = {},
        oldMinutes = oldMinutes,
        onMinutesChanged = {},
        onTimeSaved = { time: String ->
            run {
                alarmClockListVm.updateAlarmClockTime(id, time)
                navController.navigate("alarmClockList")
            }
        })

@Composable
private fun TimePicker(
    oldHours: Int?, onHoursChanged: (hours: Int?) -> Unit,
    oldMinutes: Int?, onMinutesChanged: (minutes: Int?) -> Unit,
    onTimeSaved: (time: String) -> Unit
) {
    val hours = remember { mutableStateOf(oldHours) }
    val minutes = remember { mutableStateOf(oldMinutes) }

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

        Button(
            onClick = { onTimeSaved("${hours.value}:${minutes.value}") },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(
                text = stringResource(id = R.string.save_time),
                style = MaterialTheme.typography.h4,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CustomTimePickerPreview() {
    TimePicker(23, {}, 23, {}, {})
}