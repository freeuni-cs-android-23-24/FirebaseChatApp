package com.example.firebasechatapp.ui.features.chat.data

import com.example.firebasechatapp.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class AppConfiguration {

    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    fun initialize() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 1
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        remoteConfig.fetchAndActivate()
    }


    fun getEmptyScreenMessage(): String {
        return remoteConfig.getString(CHAT_EMPTY_SCREEN_MESSAGE_KEY)
    }

    companion object {
        const val CHAT_EMPTY_SCREEN_MESSAGE_KEY = "chat_empty_screen_message"

        private val instance: AppConfiguration? = null

        fun getInstance(): AppConfiguration {
            return instance ?: AppConfiguration()
        }
    }
}