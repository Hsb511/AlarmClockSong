package com.example.alarmclocksong.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
inline fun TimeTextField(
    initTime: MutableState<TextFieldValue>,
    crossinline onValueChange: (time: TextFieldValue) -> String
) {
    OutlinedTextField(
        value = initTime.value,
        onValueChange = {
            initTime.value = TextFieldValue(
                onValueChange(it),
                it.selection,
                it.composition
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            textColor = MaterialTheme.colors.primary,
        ),
        textStyle = MaterialTheme.typography.h3,
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showSystemUi = true)
@Composable
fun TimeTextFieldPreview() {
    val time: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue("23")) }
    Row {
        TimeTextField(time) { "" }
    }
}