package com.example.businesscalendar.core.presentation.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.businesscalendar.core.presentation.ui.theme.Blue40
import com.example.businesscalendar.core.presentation.ui.theme.Gray10

@Composable
fun BottomNavigationBar(
    navController: NavController){

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.AddItem,
        NavigationItem.More,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarDestination = items.any { it.screen.route == currentRoute }

    if (bottomBarDestination) {

        BottomNavigation(
            modifier = Modifier.height(79.dp),
            backgroundColor = Color.White,
            contentColor = Gray10
        ) {

            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                        imageVector = ImageVector.vectorResource(id = item.icon),
                        contentDescription = item.title,
                        tint = Gray10
                    )
                           },
                    selectedContentColor = Blue40,
                    unselectedContentColor = Gray10,
                    selected = currentRoute == item.screen.route,
                    onClick = { navController.navigate(item.screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true

                    } }
                )
            }
        }
    }

}