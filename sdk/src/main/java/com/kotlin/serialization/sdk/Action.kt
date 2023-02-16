package com.kotlin.serialization.sdk

import kotlinx.serialization.Serializable

@Serializable
class Action(
    private val foo: String,
    private val extraData: SdkExtraData? = null
)