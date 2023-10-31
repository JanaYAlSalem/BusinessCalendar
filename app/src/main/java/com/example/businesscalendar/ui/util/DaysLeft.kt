package com.example.businesscalendar.ui.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
fun daysLeft (date : String) : Int{
    println("@@@@@@@@@@@@@ ${date}")
    val eDate = date.split("/").reversed().joinToString("-")
    println("@@@@@@@@@@@@@ ${eDate}")
//    val futureDate = LocalDate.parse(eDate)
//    // get the difference in full days
//    val daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), futureDate)
//    // print the result
//    println("@@@@@@@@@@@@@ $daysLeft days left")
    return 0
}

@RequiresApi(Build.VERSION_CODES.O)
fun isBefore90DaysLeft (date : String) : Boolean {
    return daysLeft(date) <= 90
}