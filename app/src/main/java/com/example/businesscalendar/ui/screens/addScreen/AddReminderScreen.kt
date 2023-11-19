package com.example.businesscalendar.ui.screens.addScreen

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Home
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.commen.components.CustomTextField
import com.example.businesscalendar.ui.commen.components.CustomTextFieldI
import com.example.businesscalendar.ui.screens.destinations.AllReminderScreenDestination
import com.example.businesscalendar.ui.theme.AccentColor
import com.example.businesscalendar.ui.theme.PrimaryColor
import com.example.businesscalendar.ui.theme.White
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.util.Calendar
import java.util.Date

@Destination
@Composable
fun AddReminderScreen(
    viewModel: AddReminderViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
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

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomTextField(
            label = "Company Name",
            endIcon = { Icon(imageVector = Icons.Outlined.AccountBox, contentDescription = null) },
            textValue = companyName ?: "",
            onValueChange = { companyName = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


        CustomTextFieldI(
            label = "Start Date",
            textValue = startDate,
            onValueChange = { startDate = it },
            listener = { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                startDate = String.format("%02d/%02d/%d", mDayOfMonth, mMonth + 1, mYear)
            },
            mDay = mDay,
            mMonth = mMonth,
            mYear = mYear
        )

        CustomTextFieldI(
            label = "End Date",
            textValue = endDate,
            onValueChange = { endDate = it },
            listener = { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                endDate = String.format("%02d/%02d/%d", mDayOfMonth, mMonth + 1, mYear)
                       },
            mDay = mDay,
            mMonth = mMonth,
            mYear = mYear
        )

        CustomTextField(
            label = "Cost",
            endIcon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = cost,
            onValueChange = { cost = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            modifier = Modifier.padding(24.dp).fillMaxWidth(),
            colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = White),
        onClick = {
            println("##${companyName}}} ${startDate} }} ${endDate} }} ${cost}")
            viewModel.insertReminder(
                ReminderItem(
                    expiredDate = endDate,
                    startDate = startDate,
                    companyName = companyName,
                    cost = cost
                )
            )
            navigator.navigateUp()
//            navigator.navigate(AllReminderScreenDestination() )

        }) {
            Text(text = "Add")
        }
    }
}
