package com.example.businesscalendar.ui.commen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscalendar.domain.model.entity.ReminderItem
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReminderCard(
    item: ReminderItem,
    onLongClick: () -> Unit,
    onClick: () -> Unit
) {
    // example input, some future date
    val input = "2024-02-24"
    val eDate = item.expiredDate.split("/").reversed().joinToString("-")
    // parse that
    val futureDate = LocalDate.parse(input)
    // get the difference in full days
    val days = ChronoUnit.DAYS.between(LocalDate.now(), futureDate)
    // print the result
    println("$days days left ${eDate}")

//    Card(modifier = Modifier
//        .fillMaxWidth()
//        .height(150.dp)
//        .padding(16.dp)
//        .combinedClickable(
//            onClick = { onClick() },
//            onLongClick = { onLongClick() }
//        )) {
//        Text(text = item.companyName)
//        Text(text = item.startDate)
//        Text(text = item.expiredDate)
//        Text(text = item.cost)
//        Text(text = "$days days left")
//    }

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .combinedClickable(
            onClick = { onClick() },
            onLongClick = { onLongClick() }
        )) {
        Row {
            Box(modifier = Modifier
                .background(Color.Gray)
                .fillMaxHeight()) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "$days")
                    Text(text = "Days left")
                }
            }
            Column {
                Text(text = item.companyName)
                Row {
                    Text(text = item.startDate)
                    Text(text = "-")
                    Text(text = item.expiredDate)
                }
                Text(text = "${item.cost} SR")
            }
        }
    }
}