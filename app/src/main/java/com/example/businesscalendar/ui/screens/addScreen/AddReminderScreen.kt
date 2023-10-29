package com.example.businesscalendar.ui.screens.addScreen

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.commen.components.CustomTextField
import com.example.businesscalendar.ui.commen.components.CustomTextFieldI
import com.ramcosta.composedestinations.annotation.Destination
import java.util.Calendar
import java.util.Date

@Destination
@Composable
fun AddReminderScreen(
    viewModel: AddReminderViewModel = hiltViewModel()
) {

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    val mYear: Int = mCalendar.get(Calendar.YEAR)
    val mMonth: Int = mCalendar.get(Calendar.MONTH)
    val mDay: Int = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()

    var companyName by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    var cost by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize()) {

        CustomTextField(
            label = "Company Name",
            Icon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = companyName,
            onValueChange = { companyName = it })


        CustomTextFieldI(
            label = "Start Date",
            Icon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = startDate,
            onValueChange = { startDate = it },
            listener = { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                startDate = String.format("%02d/%02d/%d", mDayOfMonth, mMonth, mYear)
            },
            mDay = mDay,
            mMonth = mMonth,
            mYear = mYear
        )

        CustomTextFieldI(
            label = "End Date",
            Icon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = endDate,
            onValueChange = { endDate = it },
            listener = { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                endDate = String.format("%02d/%02d/%d", mDayOfMonth, mMonth, mYear)
            },
            mDay = mDay,
            mMonth = mMonth,
            mYear = mYear
        )

        CustomTextField(
            label = "Cost",
            Icon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = cost,
            onValueChange = { cost = it })

        Button(onClick = {
            viewModel.insertReminder(
                ReminderItem(
                    expiredDate = endDate,
                    startDate = startDate,
                    companyName = companyName,
                    cost = cost
                )
            )
        }) {
            Text(text = "Add")
        }
    }
}