package com.example.businesscalendar.ui.screens.addScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.commen.components.CustomTextField
import com.example.businesscalendar.ui.theme.AccentColor
import com.ramcosta.composedestinations.annotation.Destination
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun AddReminderScreen(
    viewModel: AddReminderViewModel = hiltViewModel(),
) {

    val startDateDialog = remember { mutableStateOf(false) }
    val endDateDialog = remember { mutableStateOf(false) }

    fun convertMillisToDate(millis: Long): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(Date(millis))
    }

    val startDatePickerState = rememberDatePickerState()
    val endDatePickerState = rememberDatePickerState()

    if (startDateDialog.value) {
        val confirmEnabled = derivedStateOf { startDatePickerState.selectedDateMillis != null }
        DatePickerDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                startDateDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        startDateDialog.value = false
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        startDateDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = startDatePickerState)
        }
    }


    if (endDateDialog.value) {
        val confirmEnabled = derivedStateOf { endDatePickerState.selectedDateMillis != null }
        DatePickerDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                startDateDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        endDateDialog.value = false
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        endDateDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = endDatePickerState)
        }
    }

    var companyName by remember { mutableStateOf("") }
    val startDate by remember { mutableStateOf("") }
    val endDate by remember { mutableStateOf("") }
    var cost by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomTextField(
            label = "Company Name",
            endIcon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = null) },
            textValue = companyName,
            onValueChange = { companyName = it })


        CustomTextField(
            label = "Start Date",
            endIcon = {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        startDateDialog.value = true
                    })
            },
            enabled = false,
            textValue = "",
            onValueChange = { startDatePickerState.selectedDateMillis?.let { convertMillisToDate(it) } },

            )

        CustomTextField(
            label = "End Date",
            endIcon = {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        endDateDialog.value = true
                    })
            },
            enabled = false,
            textValue = endDatePickerState.selectedDateMillis?.let { convertMillisToDate(it) }.toString(),
            onValueChange = {
                endDatePickerState.selectedDateMillis?.let { convertMillisToDate(it) }.toString()
                            },
        )

        CustomTextField(
            label = "Cost",
            endIcon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = cost,
            onValueChange = { cost = it })

        Button(
            modifier = Modifier.padding(24.dp),
            onClick = {
                viewModel.insertReminder(
                    ReminderItem(
                        expiredDate = endDate,
                        startDate = startDate,
                        companyName = companyName,
                        cost = cost
                    )
                )
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = AccentColor)

        ) {
            Text(color = Color.White, text = "Add")
        }
    }
}

@Preview
@Composable
fun AddReminderScreenPreview() {
    AddReminderScreen()
}