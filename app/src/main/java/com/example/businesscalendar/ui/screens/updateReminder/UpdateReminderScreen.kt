package com.example.businesscalendar.ui.screens.updateReminder

import android.widget.DatePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.commen.components.CustomTextField
import com.example.businesscalendar.ui.commen.components.CustomTextFieldI
import com.example.businesscalendar.ui.screens.addScreen.AddReminderViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.util.Calendar
import java.util.Date

@Destination
@Composable
fun UpdateReminderScreen(
    viewModel: UpdateReminderViewModel = hiltViewModel(),
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
                startDate = "$mDayOfMonth/${mMonth + 1}/$mYear"
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
                endDate = "$mDayOfMonth/${mMonth + 1}/$mYear"
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
            viewModel.updateReminder(
                ReminderItem(
                    expiredDate = endDate,
                    startDate = startDate,
                    companyName = companyName,
                    cost = cost
                )
            )
        }) {
            Text(text = "Update")
        }
    }

}