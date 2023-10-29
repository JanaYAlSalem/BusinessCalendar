package com.example.businesscalendar.ui.commen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.businesscalendar.ui.theme.Gray10
import com.example.businesscalendar.ui.theme.PrimaryColor

@Composable
fun CustomTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    label: String,
    enabled: Boolean = true,
    endIcon: @Composable (() -> Unit)? = null,
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
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}