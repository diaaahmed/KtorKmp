package org.ktor.ktorkmp.data.model

import org.ktor.ktorkmp.domain.entity.CurrencyPrice


data class CurrencyPriceModel(
    val buy: String,
    val currency: String,
    val sell: String,
    val flag: String
)


fun CurrencyPrice.toModel():CurrencyPriceModel{
    return CurrencyPriceModel(
        buy = this.buy,
        currency = this.currency,
        sell = this.sell,
        flag = this.flag
    )
}