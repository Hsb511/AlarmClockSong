package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.alarmclocksong.R
import com.example.alarmclocksong.ui.extensions.getHoursFromTime
import com.example.alarmclocksong.ui.extensions.getMinutesFromTime
import com.example.alarmclocksong.ui.viewmodels.AlarmClockListVM
import com.example.alarmclocksong.ui.viewobjects.AlarmClockVO

@ExperimentalFoundationApi
@Composable
fun AlarmClockList(
    navController: NavHostController,
    alarmClockListVm: AlarmClockListVM = AlarmClockListVM()
) =
    AlarmClockList(
        alarmClocks = alarmClockListVm.alarmClocks,
        onPickTime = { alarmClock ->
            navController.navigate(
                "timePicker/${alarmClock.id}" +
                        "?hours=${alarmClock.time.getHoursFromTime()}" +
                        "?minutes=${alarmClock.time.getMinutesFromTime()}"
            )
        },
        onRemoveAlarmClock = { alarmClock -> alarmClockListVm.removeAlarmClock(alarmClock) },
        addAlarmClock = { alarmClockListVm.addAlarmClock() }
    )


@ExperimentalFoundationApi
@Composable
private fun AlarmClockList(
    alarmClocks: List<AlarmClockVO>,
    onPickTime: (alarmClock: AlarmClockVO) -> Unit,
    onRemoveAlarmClock: (alarmClock: AlarmClockVO) -> Unit,
    addAlarmClock: () -> Unit
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp, 8.dp, 4.dp, 4.dp)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.alarm_clock_title),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
            )
        }

        items(alarmClocks) {
            AlarmClock(
                time = it.time, enabled = it.state,
                modifier = Modifier.combinedClickable(
                    onClick = { onPickTime(it) },
                    onLongClick = { onRemoveAlarmClock(it) })
            )
        }
        item {
            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    onClick = { addAlarmClock() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    shape = RoundedCornerShape(32.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.alarm_clock_add),
                        modifier = Modifier.padding(32.dp, 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@ExperimentalFoundationApi
@Composable
fun AlarmClockListPreview() {
    AlarmClockList(
        listOf(
            AlarmClockVO(1, "00:00", true),
            AlarmClockVO(2, "00:23", false),
            AlarmClockVO(3, "23:00", true),
            AlarmClockVO(4, "23:23", false)
        ), {}, {}, {})
}


