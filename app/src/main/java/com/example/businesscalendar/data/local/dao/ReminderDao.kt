package com.example.businesscalendar.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.businesscalendar.domain.model.entity.ReminderItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {

    @Query("SELECT * FROM reminder_item")
    fun getAllReminders() : Flow<List<ReminderItem>>

    @Query("SELECT * from reminder_item WHERE id = :id")
    fun getReminder(id: Int): Flow<ReminderItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReminder(reminderItem: ReminderItem)

    @Update
    suspend fun updateReminder(reminderItem: ReminderItem)

    @Delete
    suspend fun deleteReminder(reminderItem: ReminderItem)

}