package com.example.businesscalendar.domain.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "reminder_item")
data class ReminderItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val companyName : String,
    val startDate: String,
    val expiredDate : String,
    val cost : String
) : Serializable