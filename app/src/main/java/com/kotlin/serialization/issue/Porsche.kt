package com.kotlin.serialization.issue

import com.kotlin.serialization.sdk.SdkExtraData
import kotlinx.serialization.Serializable

@Serializable
data class Porsche(
    private val model: String,
    private val generation: Int
) : SdkExtraData()