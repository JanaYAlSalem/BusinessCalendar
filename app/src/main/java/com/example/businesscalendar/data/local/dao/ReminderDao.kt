package com.example.businesscalendar.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.businesscalendar.domain.model.entity.ReminderItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {

    @Query("SELECT * FROM reminder_item")
    fun getAllReminders() : Flow<List<ReminderItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addReminder(reminderItem: ReminderItem)

    @Delete
    fun deleteReminder(reminderItem: ReminderItem)

}