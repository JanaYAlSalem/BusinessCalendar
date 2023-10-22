package com.example.businesscalendar.core.presentation.ui.app_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscalendar.core.presentation.ui.theme.Blue40
import com.example.businesscalendar.core.presentation.ui.theme.Gray10

@Composable
fun CustomTextField(
    textValue : String,
    onValueChange: (String) -> Unit,
    label: String,
    Icon: @Composable (() -> Unit)? = null,
) {

    OutlinedTextField(
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Gray10,
            focusedLabelColor = Blue40,
            focusedBorderColor = Blue40,
            leadingIconColor = Gray10,
        ),
        leadingIcon = Icon,
        value = textValue,
        onValueChange = onValueChange ,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    var textState by remember { mutableStateOf("") }

Column() {
    CustomTextField(label = "Email", Icon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = null) }
        , textValue = textState, onValueChange = {textState = it} )

    CustomTextField(label = "Password", Icon = { Icon(imageVector = Icons.Outlined.Done, contentDescription = null) }
        , textValue = textState, onValueChange = {textState = it} )
}
}