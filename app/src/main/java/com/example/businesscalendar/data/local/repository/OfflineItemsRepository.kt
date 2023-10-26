package com.example.businesscalendar.data.local.repository

import com.example.businesscalendar.data.db.AppDataBase
import com.example.businesscalendar.data.local.dao.ReminderDao
import com.example.businesscalendar.domain.model.entity.ReminderItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfflineReminderRepository @Inject constructor(db: AppDataBase) : IReminderRepository {

    private val reminderDao = db.reminderDao()

    override fun getAllItemsStream(): Flow<List<ReminderItem>> = reminderDao.getAllReminders()

    override fun getItemStream(id: Int): Flow<ReminderItem?> = reminderDao.getReminder(id = id)

    override suspend fun addReminder(reminderItem: ReminderItem) = reminderDao.addReminder(reminderItem = reminderItem)

    override suspend fun updateReminder(reminderItem: ReminderItem) = reminderDao.updateReminder(reminderItem = reminderItem)

    override suspend fun deleteReminder(reminderItem: ReminderItem) = reminderDao.deleteReminder(reminderItem = reminderItem)
}