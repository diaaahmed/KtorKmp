package org.ktor.ktorkmp.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GoldResponse(
    @SerialName("gold_prices")
    val gold_prices: List<GoldPrice>
)
