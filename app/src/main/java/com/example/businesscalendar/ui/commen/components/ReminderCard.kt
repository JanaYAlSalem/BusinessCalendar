package com.example.businesscalendar.ui.commen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ReminderCard (componyName : String) {

    Card(modifier = Modifier.fillMaxWidth().height(200.dp).padding(16.dp)) {
        Text(text = componyName)
    }
}

@Preview(showBackground = true)
@Composable
fun ReminderCardPreview() {
    ReminderCard("HI")
}