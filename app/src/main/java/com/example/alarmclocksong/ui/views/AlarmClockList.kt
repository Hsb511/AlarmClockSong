package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alarmclocksong.domain.model.AlarmClockVO
import com.example.alarmclocksong.ui.theme.ACSTheme
import com.example.alarmclocksong.ui.viewmodels.AlarmClockListVM

@ExperimentalFoundationApi
@Composable
fun AlarmClockList(alarmClockListVm: AlarmClockListVM = AlarmClockListVM()) {
    ACSTheme {
        LazyColumn(modifier = Modifier.padding(4.dp, 8.dp, 4.dp, 4.dp)) {
            items(alarmClockListVm.alarmClocks) {
                AlarmClock(
                    time = it.time, enabled = it.state,
                    modifier = Modifier.combinedClickable(
                        onClick = {
                            //TODO OPENING A NEW FRAGMENT TO CHANGE THE TIME
                        },
                        onLongClick = { alarmClockListVm.removeAlarmClock(it) })
                )
            }
            item {
                CustomBox(Modifier.clickable { alarmClockListVm.addAlarmClock() }) {
                    Text(
                        text = "+",
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlarmClockListPreview() {
    ACSTheme {
        LazyColumn {
            items(
                listOf(
                    AlarmClockVO("00:00", true),
                    AlarmClockVO("00:23", false),
                    AlarmClockVO("23:00", true),
                    AlarmClockVO("23:23", false)
                )
            ) {
                AlarmClock(time = it.time, enabled = it.state)
            }

            item {
                CustomBox {
                    Text(
                        text = "+",
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

