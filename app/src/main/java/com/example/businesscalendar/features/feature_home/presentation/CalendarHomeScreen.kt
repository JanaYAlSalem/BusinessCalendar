package com.example.businesscalendar.features.feature_home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.businesscalendar.core.presentation.navigation.BottomNavigationBar

@Composable
fun  CalendarHomeScreen (
    navController: NavController
) {


    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
                    
                    It also contains some basic inner content, such as this text.
                    
                    You have pressed the floating action button times.
                """.trimIndent(),
            )
        }
    }
}