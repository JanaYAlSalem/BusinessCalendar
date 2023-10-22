package com.example.businesscalendar.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.businesscalendar.features.feature_home.presentation.CalendarHomeScreen
import com.example.businesscalendar.features.feature_splash.presentation.SplashScreen

@Composable
fun AppNavigation () {

    val navController = rememberNavController()
    val navBarController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {

        // 1- Splash screen
        composable(AppScreens.SplashScreen.route) { SplashScreen(navController = navController) }
        // 2- Sign in screen
        // 3- Sign up screen
        // 4- Calendar home screen
        composable(AppScreens.CalendarHomeScreen.route) { CalendarHomeScreen(navController = navController) }



    }

}