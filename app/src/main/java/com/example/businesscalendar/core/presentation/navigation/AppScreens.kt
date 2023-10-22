package com.example.businesscalendar.core.presentation.navigation

sealed class AppScreens (val route: String, val title: String) {

    // 1- Splash screen
    object SplashScreen : AppScreens("SplashScreen", "Business Calendar")
    // 2- Sign in screen
    object SignInScreen : AppScreens("SignInScreen", "Sign In")
    // 3- Sign up screen
    object SignUpScreen : AppScreens("SignUpScreen", "Business Calendar")
    // 4- Calendar home screen
    object CalendarHomeScreen : AppScreens("CalendarHomeScreen", "Business Calendar")

}
