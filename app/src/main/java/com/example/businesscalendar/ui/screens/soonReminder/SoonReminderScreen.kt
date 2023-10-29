package com.example.businesscalendar.ui.screens.soonReminder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.businesscalendar.ui.commen.components.ReminderCard
import com.example.businesscalendar.ui.screens.allReminder.AllReminderViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import androidx.compose.foundation.lazy.items
import com.example.businesscalendar.ui.screens.destinations.UpdateReminderScreenDestination


@RequiresApi(Build.VERSION_CODES.O)
@Destination
@Composable
fun SoonReminderScreen (
    viewModel: AllReminderViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state by viewModel.soonReminderViewState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.padding(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        LazyColumn(content = {
            items(state?.soonList ?: emptyList()) { item ->
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