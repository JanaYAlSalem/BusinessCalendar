package com.example.businesscalendar.ui.commen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.theme.Black
import com.example.businesscalendar.ui.theme.Gray10
import com.example.businesscalendar.ui.theme.SecondaryColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReminderCard(
    item: ReminderItem,
    onLongClick: () -> Unit,
    onClick: () -> Unit
) {

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .combinedClickable(
            onClick = { onClick() },
            onLongClick = { onLongClick() }
        ) ,
        colors = CardDefaults.cardColors(
            containerColor = SecondaryColor, //Card background color
            contentColor = Black  //Card content color,e.g.text
        )
    ) {
        Row (Modifier.padding(start = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp))
                    .background(Gray10)
            )
            {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  //  Text(text = "${daysLeft(item.expiredDate)}")
                    Text(text = "Days left")
                }
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
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