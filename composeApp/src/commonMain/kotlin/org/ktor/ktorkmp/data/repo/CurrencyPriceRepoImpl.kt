package org.ktor.ktorkmp.data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ktor.ktorkmp.app.HttpRoutes
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.data.model.toModel
import org.ktor.ktorkmp.domain.entity.CurrencyResponse
import org.ktor.ktorkmp.domain.repo.CurrencyPriceRepo
import org.ktor.ktorkmp.domain.util.Result

class CurrencyPriceRepoImpl(
    private val httpClient: HttpClient

): CurrencyPriceRepo {

    override suspend fun getCurrencyPrice(): Flow<Result<List<CurrencyPriceModel>>> = flow {

        emit(Result.Loading())

        try {
            val getCurrencyPrice = httpClient.get{
                url(HttpRoutes.currencyPrice)
            }.body<CurrencyResponse>()

            val prices = getCurrencyPrice.currency_prices.map {
                it.toModel()
            }
            emit(Result.Success(prices))

        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}