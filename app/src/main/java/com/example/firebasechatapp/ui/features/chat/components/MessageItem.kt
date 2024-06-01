package com.example.firebasechatapp.ui.features.chat.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageItem(modifier: Modifier = Modifier, message: Message) {
    Column(modifier = modifier) {
        Text(
            style = MaterialTheme.typography.labelSmall,
            text = message.sender
        )
        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    text = message.text)
            }
        }
    }
}

@Preview
@Composable
private fun MessageItemPreview() {
    MessageItem(
        message = Message("Hello", "Me")
    )
}