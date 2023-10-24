package com.example.businesscalendar.features.feature_add_reminder.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.businesscalendar.core.presentation.navigation.BottomNavigationBar
import com.example.businesscalendar.core.presentation.ui.app_components.CustomTextField
import com.example.businesscalendar.core.presentation.ui.theme.Gray10

@Composable
fun  AddReminderScreen (
    navController: NavController
) {
    var textState by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        backgroundColor = Gray10
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = "Add new reminder")
            CustomTextField(
                label = "Email",
                Icon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = null) },
                textValue = textState,
                onValueChange = { textState = it }
            )
        }
    }

}