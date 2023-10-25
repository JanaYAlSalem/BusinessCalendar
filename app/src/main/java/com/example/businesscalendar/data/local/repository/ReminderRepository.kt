package com.example.businesscalendar.data.local.repository

import com.example.businesscalendar.domain.model.entity.ReminderItem
import kotlinx.coroutines.flow.Flow

interface ReminderRepository {

    fun getAllItemsStream(): Flow<List<ReminderItem>>
    fun getItemStream(id: Int): Flow<ReminderItem?>
    suspend fun addReminder(reminderItem: ReminderItem)
    suspend fun updateReminder(reminderItem: ReminderItem)
    suspend fun deleteReminder(reminderItem: ReminderItem)

}