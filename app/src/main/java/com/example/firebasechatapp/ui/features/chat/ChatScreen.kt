package com.example.firebasechatapp.ui.features.chat

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebasechatapp.ui.features.chat.components.ChatInput

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    Row {
        ChatMessages()
        ChatInput(onMessageSent = {})
    }
}

@Preview
@Composable
private fun ChatScreenPreview() {
    ChatScreen()
}


@Composable
fun ChatMessages(modifier: Modifier = Modifier) {

}