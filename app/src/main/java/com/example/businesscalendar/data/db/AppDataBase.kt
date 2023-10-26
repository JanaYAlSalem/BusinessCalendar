package com.example.businesscalendar.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.businesscalendar.data.local.dao.ReminderDao
import com.example.businesscalendar.domain.model.entity.ReminderItem

@Database(
    entities = [
        ReminderItem::class

    ],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun reminderDao() : ReminderDao

    companion object {
        const val DB_NAME = "appDataBase.db"
    }
}