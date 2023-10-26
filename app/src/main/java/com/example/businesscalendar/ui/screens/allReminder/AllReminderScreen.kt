package com.example.businesscalendar.ui.screens.allReminder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.businesscalendar.ui.commen.components.ReminderCard
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AllReminderScreen (
    viewModel: AllReminderViewModel = hiltViewModel()
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.padding(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {


        LazyColumn(content = {
            items(state?.reminderList ?: emptyList()) { item ->
                ReminderCard(item.companyName)
            }
        })
    }
}

@Preview
@Composable
fun AllReminderScreenPreview(){

    AllReminderScreen()
}