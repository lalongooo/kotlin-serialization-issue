package com.kotlin.serialization.sdk_api

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.encodeToJsonElement
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

class SdkApi<EventData : Any> constructor(
    private val eventDataKClass: KClass<EventData>,
    private val appSerializersModule: SerializersModule
) {
    private val json by lazy {
        Json {
            serializersModule = appSerializersModule
        }
    }

    @OptIn(InternalSerializationApi::class)
    fun send(event: EventData) {
        val element = encodeToJsonElement(eventDataKClass.serializer(), event)
        val jsonString = json.encodeToString(element)
        println(jsonString)
    }
}