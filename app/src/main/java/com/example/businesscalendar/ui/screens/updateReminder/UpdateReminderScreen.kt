package com.example.businesscalendar.ui.screens.updateReminder

import android.widget.DatePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.commen.components.CustomTextField
import com.example.businesscalendar.ui.commen.components.CustomTextFieldI
import com.ramcosta.composedestinations.annotation.Destination
import java.util.Calendar
import java.util.Date

@Destination
@Composable
fun UpdateReminderScreen(
    item: ReminderItem,
    viewModel: UpdateReminderViewModel = hiltViewModel()
) {

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    val mYear: Int = mCalendar.get(Calendar.YEAR)
    val mMonth: Int = mCalendar.get(Calendar.MONTH)
    val mDay: Int = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()


    var companyName by remember { mutableStateOf(item.companyName) }
    var startDate by remember { mutableStateOf(item.startDate) }
    var endDate by remember { mutableStateOf(item.expiredDate) }
    var cost by remember { mutableStateOf(item.cost) }


    Column(modifier = Modifier.fillMaxSize()) {

        CustomTextField(
            label = "Company Name",
            endIcon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) },
            textValue = companyName,
            onValueChange = { companyName = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


        CustomTextFieldI(
            label = "Start Date",
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
            endIcon = { Icon(imageVector = Icons.Outlined.Info, contentDescription = null) },
            textValue = cost,
            onValueChange = { cost = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

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