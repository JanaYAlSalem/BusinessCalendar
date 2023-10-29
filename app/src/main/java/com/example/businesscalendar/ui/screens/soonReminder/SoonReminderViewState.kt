package com.example.businesscalendar.ui.screens.soonReminder

import com.example.businesscalendar.domain.model.entity.ReminderItem

data class SoonReminderViewState(
    val soonList: List<ReminderItem>? = null,
    val error: Boolean? = null
)