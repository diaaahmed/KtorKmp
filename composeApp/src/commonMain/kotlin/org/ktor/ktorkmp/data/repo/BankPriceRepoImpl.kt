package org.ktor.ktorkmp.data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ktor.ktorkmp.app.HttpRoutes
import org.ktor.ktorkmp.domain.entity.BankPrice
import org.ktor.ktorkmp.domain.entity.BankResponse
import org.ktor.ktorkmp.domain.repo.BankPriceRepo
import org.ktor.ktorkmp.domain.util.Result

class BankPriceRepoImpl(
    private val httpClient: HttpClient

): BankPriceRepo {

    override suspend fun getBankPrice(): Flow<Result<List<BankPrice>>>  = flow {

        emit(Result.Loading())

        try {
            val getGoldPrice = httpClient.get{
                url(HttpRoutes.bankPrices)
            }.body<BankResponse>()

            val prices = getGoldPrice.bank_prices

            emit(Result.Success(prices))

        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}