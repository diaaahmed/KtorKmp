package org.ktor.ktorkmp.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyPrice(
    @SerialName("buy")
    val buy: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("sell")
    val sell: String,
    @SerialName("flag")
    val flag: String
)