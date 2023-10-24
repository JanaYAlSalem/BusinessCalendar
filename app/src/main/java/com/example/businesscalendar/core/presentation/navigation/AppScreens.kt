package com.example.businesscalendar.core.presentation.navigation

sealed class AppScreens (val route: String, val title: String) {


    // 2- Sign in screen
    object SignInScreen : AppScreens("SignInScreen", "Sign In")
    // 3- Sign up screen
    object SignUpScreen : AppScreens("SignUpScreen", "Sign up")
    // 4- Calendar home screen
    object CalendarHomeScreen : AppScreens("CalendarHomeScreen", "Business Calendar")
    // 5- Add reminder screen
    object AddReminderScreen : AppScreens("AddReminderScreen", "Add Reminder")


}
