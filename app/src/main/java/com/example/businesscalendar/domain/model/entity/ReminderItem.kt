package com.example.businesscalendar.domain.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "reminder_item")
data class ReminderItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val companyName: String? = null,
    val startDate: String? = null,
    val expiredDate: String? = null,
    val cost: String? = null
) : Serializable