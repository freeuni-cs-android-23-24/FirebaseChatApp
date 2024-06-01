package com.example.firebasechatapp

import android.app.Application
import com.example.firebasechatapp.ui.features.chat.data.AppConfiguration

class FirebaseChatApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        AppConfiguration.getInstance().initialize()
    }
}