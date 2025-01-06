package org.ktor.ktorkmp.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BankPrice(
    @SerialName("bank")
    val bank: String,
    @SerialName("buy")
    val buy: String,
    @SerialName("sell")
    val sell: String,
    @SerialName("flag")
    val flag: String
)