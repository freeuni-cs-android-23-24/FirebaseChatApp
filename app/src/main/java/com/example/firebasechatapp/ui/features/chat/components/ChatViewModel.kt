package com.example.firebasechatapp.ui.features.chat.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.snapshots
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.random.Random

class ChatViewModel : ViewModel() {

    private val _state = MutableStateFlow<ChatViewState>(ChatViewState.Loading)
    val state: StateFlow<ChatViewState> = _state.asStateFlow()

    private val messagesCollection = Firebase.firestore
        .collection("chatroom")
        .document("chat-1")
        .collection("messages")

    private val userName = "user_${Random.nextInt(0, 100)}"


    init {
        viewModelScope.launch {
            messagesCollection.snapshots().collectLatest { snapshot ->
                val messages = snapshot.documents.map {
                    Message(
                        text = it.getString("text")!!,
                        sender = it.getString("sender")!!
                    )
                }
                _state.value = ChatViewState.Content(messages)
            }
        }
    }

    fun onSendMessage(message: String) {
        messagesCollection.add(
            mapOf(
                "text" to message,
                "sender" to userName
            )
        )
    }

}


sealed interface ChatViewState {
    data object Loading : ChatViewState

    data class Content(
        val messages: List<Message>
    ) : ChatViewState
}

data class Message(
    val text: String,
    val sender: String
)