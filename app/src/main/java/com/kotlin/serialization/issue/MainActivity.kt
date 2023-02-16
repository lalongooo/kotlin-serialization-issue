package com.kotlin.serialization.issue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.serialization.sdk.Action
import com.kotlin.serialization.sdk.Sdk
import com.kotlin.serialization.sdk.SdkExtraData
import com.kotlin.serialization.issue.databinding.ActivityMainBinding
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        serializeStuff()
    }

    private fun serializeStuff() {
        val action = Action(
            foo = "Android",
            extraData = Porsche(model = "911", generation = 992)
        )
        val module = buildSerializersModule()
        val sdk = Sdk.create(module)
        sdk.sendAction(action)
    }


    private fun buildSerializersModule() = SerializersModule {
        polymorphic(SdkExtraData::class) {
            subclass(Porsche::class)
        }
    }

}