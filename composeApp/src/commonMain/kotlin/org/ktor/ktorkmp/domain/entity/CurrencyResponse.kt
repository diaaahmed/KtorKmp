package org.ktor.ktorkmp.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyResponse(
    @SerialName("currency_prices")
    val currency_prices: List<CurrencyPrice>
)