package com.example.businesscalendar.ui.screens.allReminder

import com.example.businesscalendar.domain.model.entity.ReminderItem

data class AllReminderViewState (
    val reminderList : List<ReminderItem>? = null ,
    val soonList : List<ReminderItem>? = null ,
    val error : Boolean? = null,
)