package com.example.firebasechatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.firebasechatapp.ui.features.chat.ChatScreen
import com.example.firebasechatapp.ui.theme.FirebaseChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirebaseChatAppTheme {
                Scaffold(
                    modifier = Modifier.imePadding(),
                    contentWindowInsets = WindowInsets(0, 0, 0, 0)
                ) { innerPadding ->
                    ChatScreen(
                        modifier = Modifier.padding(innerPadding)
                            .consumeWindowInsets(innerPadding)
                            .systemBarsPadding()
                    )
                }
            }
        }
    }
}
