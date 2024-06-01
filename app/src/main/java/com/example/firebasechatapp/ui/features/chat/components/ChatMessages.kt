package com.example.firebasechatapp.ui.features.chat.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Composable function to display a list of chat messages.
 *
 * @param modifier The modifier to be applied to the root element.
 * @param messages The list of messages to be displayed.
 *
 */
@Composable
fun ChatMessages(
    modifier: Modifier = Modifier,
    emptyScreenMessage: String,
    messages: List<Message>
) {
    if (messages.isEmpty()) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center) {
            Text(
                style = MaterialTheme.typography.headlineSmall,
                text = emptyScreenMessage
            )
        }
        return
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(messages.size) {
            MessageItem(message = messages[it])
        }
    }
}

@Preview
@Composable
private fun ChatMessagesPreview() {
    ChatMessages(
        emptyScreenMessage = "",
        messages = listOf(
            Message("Hello", "Me"),
            Message("Hi", "You"),
            Message("See you later", "Me"),
        )
    )
}

@Preview
@Composable
private fun ChatMessagesEmptyPreview() {
    ChatMessages(
        emptyScreenMessage = "Hey, send a message!",
        messages = emptyList()
    )
}