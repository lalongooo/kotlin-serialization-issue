package com.kotlin.serialization.sdk

import com.kotlin.serialization.sdk_api.SdkApi
import kotlinx.serialization.modules.SerializersModule

class Sdk constructor(private val sdkApi: SdkApi<Action>) {
    companion object {
        fun create(
            projectSerializersModule: SerializersModule
        ): Sdk {
            val sdkApi = SdkApi(Action::class, projectSerializersModule)
            return Sdk(sdkApi)
        }
    }
    fun sendAction(action: Action) {
        sdkApi.send(action)
    }
}