package org.ktor.ktorkmp.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GoldPrice(
    @SerialName("buy")
    val buy: String,
    @SerialName("karat")
    val karat: String,
    @SerialName("sell")
    val sell: String
)