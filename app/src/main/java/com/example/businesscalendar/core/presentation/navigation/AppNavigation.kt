package com.example.businesscalendar.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.businesscalendar.features.feature_add_reminder.presentation.AddReminderScreen
import com.example.businesscalendar.features.feature_home.presentation.CalendarHomeScreen

@Composable
fun AppNavigation () {

    val navController = rememberNavController()
    val navBarController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.CalendarHomeScreen.route) {

        // 1- Calendar Home Screen
        composable(AppScreens.CalendarHomeScreen.route) { CalendarHomeScreen(navController = navController) }
        // 2- Sign in screen
        // 3- Sign up screen
        // 5- Add reminder screen
        composable(AppScreens.AddReminderScreen.route) { AddReminderScreen(navController = navController) }




    }

}