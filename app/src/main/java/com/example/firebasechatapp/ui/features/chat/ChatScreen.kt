package com.example.firebasechatapp.ui.features.chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebasechatapp.ui.features.chat.components.ChatInput
import com.example.firebasechatapp.ui.features.chat.components.ChatMessages
import com.example.firebasechatapp.ui.features.chat.components.ChatViewModel
import com.example.firebasechatapp.ui.features.chat.components.ChatViewState

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    viewModel: ChatViewModel = viewModel()

) {
    val state = viewModel.state.collectAsState().value
    when (state) {
        is ChatViewState.Loading -> ChatLoading(modifier)
        is ChatViewState.Content -> ChatContent(
            modifier,
            content = state,
            onMessageSent = viewModel::onSendMessage
        )
    }
}

@Composable
private fun ChatLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun ChatContent(
    modifier: Modifier = Modifier,
    content: ChatViewState.Content,
    onMessageSent: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        ChatMessages(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            messages = content.messages
        )
        ChatInput(
            modifier = Modifier.fillMaxWidth(),
            onMessageSent = onMessageSent
        )
    }
}

@Preview
@Composable
private fun ChatContentPreview() {
    ChatContent(content = ChatViewState.Content(messages = emptyList()), onMessageSent = {})
}
