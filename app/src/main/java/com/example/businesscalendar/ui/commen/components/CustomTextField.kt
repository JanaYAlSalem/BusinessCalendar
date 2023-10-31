package com.example.businesscalendar.ui.commen.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscalendar.ui.theme.Gray10
import com.example.businesscalendar.ui.theme.PrimaryColor
import java.util.Calendar
import java.util.Date

@Composable
fun CustomTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    label: String,
    enabled: Boolean = true,
    endIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions

) {

    OutlinedTextField(
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Gray10,
            focusedLabelColor = PrimaryColor,
            focusedBorderColor = PrimaryColor,
            leadingIconColor = Gray10,
        ),
        enabled = enabled,
        leadingIcon = endIcon,
        value = textValue,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
                label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@Composable
fun CustomTextFieldI(
    textValue: String,
    onValueChange: (String) -> Unit,
    label: String,
    listener : DatePickerDialog.OnDateSetListener,
    mYear : Int,
    mMonth:Int,
    mDay : Int,
) {
    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = android.app.DatePickerDialog(
        mContext,
        listener,
        mYear
        , mMonth
        , mDay
    )

    OutlinedTextField(
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Gray10,
            focusedLabelColor = PrimaryColor,
            focusedBorderColor = PrimaryColor,
            leadingIconColor = Gray10,
        ),
        enabled = false,
        leadingIcon = { Icon(imageVector = Icons.Outlined.DateRange, contentDescription = null, modifier = Modifier.clickable {mDatePickerDialog.show()}) },
        value = textValue,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}
