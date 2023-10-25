package com.example.businesscalendar.ui.screens.allReminder

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllReminderViewModel @Inject constructor():ViewModel(){

    val list = listOf(
        MockList("1"),
        MockList("2"),
        MockList("3"),
        MockList("4"),
        MockList("5"),
        MockList("6"),
    )

}

data class MockList(
    val name:String
)