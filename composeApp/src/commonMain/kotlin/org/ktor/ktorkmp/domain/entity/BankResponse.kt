package org.ktor.ktorkmp.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BankResponse(
    @SerialName("bank_prices")
    val bank_prices: List<BankPrice>
)