package com.example.businesscalendar.core.presentation.navigation
import com.example.businesscalendar.R

sealed class NavigationItem(var screen: AppScreens, var icon: Int, var title: String) {

    // 1- calendar home
    object Home : NavigationItem(
        screen = AppScreens.CalendarHomeScreen,
        icon = R.drawable.ic_calendar,
        title = "Home"
    )

    // 2- Add Screen
    object AddItem : NavigationItem(
        screen = AppScreens.AddReminderScreen,
        icon = R.drawable.ic_add,
        title = "Add Item"
    )

    // 3- more
    object More : NavigationItem(
        screen = AppScreens.CalendarHomeScreen,
        icon = R.drawable.ic_more,
        title = "Add Item"
    )


}
