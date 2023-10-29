package com.example.businesscalendar.ui.commen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusTarget
import androidx.navigation.compose.rememberNavController
import com.example.businesscalendar.ui.screens.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun MainScaffold() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        Box (modifier = Modifier.padding(it)){
            DestinationsNavHost(
                modifier = Modifier.focusTarget(),
                navController = navController,
                navGraph = NavGraphs.root
            )
        }
    }
}