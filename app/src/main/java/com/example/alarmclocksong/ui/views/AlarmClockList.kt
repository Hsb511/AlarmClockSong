package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alarmclocksong.domain.model.AlarmClockVO
import com.example.alarmclocksong.ui.theme.ACSTheme
import com.example.alarmclocksong.ui.viewmodels.AlarmClockListVM

@Composable

fun AlarmClockList(alarmClockListVm: AlarmClockListVM = AlarmClockListVM()) {

    val alarmClocks: List<AlarmClockVO> by alarmClockListVm.alarmClocks.observeAsState(listOf())

        ACSTheme {
        LazyColumn(modifier = Modifier.padding(4.dp, 8.dp, 4.dp, 4.dp)) {
            items(alarmClocks) {
                AlarmClock(it.time, it.state)
            }
            item {
                CustomBox {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "+",
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.primary
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
            items(listOf("23:23", "00:23", "23:00", "00:00")) {
                AlarmClock(it, false)
            }
        }

        Text(text = "+")
    }
}

