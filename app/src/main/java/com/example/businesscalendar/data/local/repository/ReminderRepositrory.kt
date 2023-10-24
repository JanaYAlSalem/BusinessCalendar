package com.example.businesscalendar.data.local.repository

import com.example.businesscalendar.domain.model.entity.ReminderItem
import kotlinx.coroutines.flow.Flow

interface ReminderRepositrory {

    fun getAllItemsStream(): Flow<List<ReminderItem>>

    suspend fun insertItem(item: ReminderItem?)

    suspend fun deleteItem(item: ReminderItem)

}