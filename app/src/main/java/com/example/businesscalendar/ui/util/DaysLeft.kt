package com.example.businesscalendar.ui.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
fun daysLeft (date : String) : Int{
    if (date == "") {
        return 0
    } else {
        try {
            val eDate = date.split("/").reversed().joinToString("-")
            val futureDate = LocalDate.parse(eDate)
            // get the difference in full days
            val daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), futureDate)
            // print the result
            println("@@@@@@@@@@@@@ ${daysLeft.toInt()} days left")


            return daysLeft.toInt()
        } catch (e: Exception) {
            return 0
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun isBefore90DaysLeft (date : String) : Boolean {
    return daysLeft(date) <= 90
}