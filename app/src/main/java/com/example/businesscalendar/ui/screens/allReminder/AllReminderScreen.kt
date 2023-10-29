package com.example.businesscalendar.ui.screens.allReminder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.businesscalendar.ui.commen.components.ReminderCard
import com.example.businesscalendar.ui.screens.destinations.UpdateReminderScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RequiresApi(Build.VERSION_CODES.O)
@Destination
@Composable
fun AllReminderScreen(
    viewModel: AllReminderViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state by viewModel.allReminderViewState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.padding(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        LazyColumn(content = {
            items(state?.reminderList ?: emptyList()) { item ->
                ReminderCard(
                    onClick = {
                        navigator.navigate(UpdateReminderScreenDestination(item))
                        },
                    onLongClick = {
                        viewModel.deleteReminder(item)
                    },
                    item = item
                )
            }
        })
    }
}