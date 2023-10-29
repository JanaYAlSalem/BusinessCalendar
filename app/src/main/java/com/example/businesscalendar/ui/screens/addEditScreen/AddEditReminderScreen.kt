package com.example.businesscalendar.ui.screens.addEditScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.commen.components.CustomTextField
import com.example.businesscalendar.ui.theme.AccentColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun AddReminderScreen(
    viewModel: AddEditReminderViewModel = hiltViewModel(),
    reminderItem: ReminderItem = ReminderItem(),
    navigator: DestinationsNavigator,
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

    val startDateValue = startDatePickerState.selectedDateMillis?.let { convertMillisToDate(it) }
    val endDateValue = endDatePickerState.selectedDateMillis?.let { convertMillisToDate(it) }

    var companyName by remember { mutableStateOf(reminderItem.companyName) }
    var startDate by remember { mutableStateOf(reminderItem.startDate) }
    var endDate by remember { mutableStateOf(reminderItem.expiredDate) }
    var cost by remember { mutableStateOf(reminderItem.cost) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomTextField(
            label = "Company Name",
            endIcon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = null) },
            textValue = companyName ?: "",
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
            textValue = startDateValue ?: "",
            onValueChange = { startDate = startDateValue },

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
            textValue = endDateValue ?: "",
            onValueChange = {
                endDate = endDateValue
            },
        )

        CustomTextField(
            label = "Cost",
            endIcon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = cost ?: "",
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
                Log.e("StartDate", "AddReminderScreen: $startDate ")
                Log.e("EndDate", "AddReminderScreen: $endDate ")
                navigator.navigateUp()
            },
            colors = ButtonDefaults.buttonColors(containerColor = AccentColor)

        ) {
            Text(color = Color.White, text = "Add")
        }
    }
}