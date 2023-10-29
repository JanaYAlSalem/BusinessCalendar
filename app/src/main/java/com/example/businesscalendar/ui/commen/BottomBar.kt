package com.example.businesscalendar.ui.commen

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.businesscalendar.R
import com.example.businesscalendar.ui.screens.NavGraphs
import com.example.businesscalendar.ui.screens.appCurrentDestinationAsState
import com.example.businesscalendar.ui.screens.destinations.AddReminderScreenDestination
import com.example.businesscalendar.ui.screens.destinations.CalendarHomeScreenDestination
import com.example.businesscalendar.ui.screens.destinations.Destination
import com.example.businesscalendar.ui.screens.destinations.DirectionDestination
import com.example.businesscalendar.ui.screens.startAppDestination
import com.example.businesscalendar.ui.theme.PrimaryColor
import com.example.businesscalendar.ui.theme.SecondaryColor
import com.ramcosta.composedestinations.navigation.navigate


@Composable
fun BottomBar(
    navController: NavController,
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    NavigationBar (contentColor = PrimaryColor,
        containerColor = SecondaryColor) {
        BottomBarDestination.values().forEach { destination ->
            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                        val navigationRoutes = BottomBarDestination.values()
                        val firstBottomBarDestination =
                            navController.currentBackStack.value.firstOrNull() { navBackStackEntry ->
                                checkForDestinations(
                                    navigationRoutes,
                                    navBackStackEntry
                                )
                            }?.destination
                        if (firstBottomBarDestination != null) {
                            popUpTo(firstBottomBarDestination.id) {
                                inclusive = true
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(
                        destination.icon,
                        contentDescription = stringResource(destination.label)
                    )
                },
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}

fun checkForDestinations(
    navigationRoutes: Array<BottomBarDestination>,
    navBackStackEntry: NavBackStackEntry
): Boolean {
    navigationRoutes.forEach {
        if (it.direction.route == navBackStackEntry.destination.route) {
            return true
        }

    }
    return false
}


enum class BottomBarDestination(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    HOME(CalendarHomeScreenDestination,Icons.Default.Home,R.string.home),
    ADD(AddReminderScreenDestination,Icons.Default.Add,R.string.add),

}