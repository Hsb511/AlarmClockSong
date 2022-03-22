package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
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
import com.example.alarmclocksong.R

@Composable
fun TimePicker(oldHours: Int, onHoursChanged: (hours: Int?) -> Unit,
               oldMinutes: Int, onMinutesChanged: (minutes: Int?) -> Unit) {
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

        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.save_time))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CustomTimePickerPreview() {
    TimePicker(23, {}, 23, {})
}