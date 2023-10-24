package com.example.businesscalendar.domain.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder_item")
data class ReminderItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
//    val companyItem : CompanyItem,
    val startDate: String,
    val expiredDate : String
)

data class CompanyItem (
    val id : Int,
    val name: String,
    val cost : Int

)