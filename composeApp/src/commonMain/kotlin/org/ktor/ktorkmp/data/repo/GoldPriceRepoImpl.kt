package org.ktor.ktorkmp.data.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ktor.ktorkmp.app.HttpRoutes
import org.ktor.ktorkmp.domain.entity.GoldPrice
import org.ktor.ktorkmp.domain.entity.GoldResponse
import org.ktor.ktorkmp.domain.repo.GoldPriceRepo
import org.ktor.ktorkmp.domain.util.Result

class GoldPriceRepoImpl(
    private val httpClient: HttpClient

): GoldPriceRepo {

    override suspend fun getGoldsData(): Flow<Result<List<GoldPrice>>>  = flow {

        emit(Result.Loading())

        try {
            val getGoldPrice = httpClient.get{
                url(HttpRoutes.goldPrices)
            }.body<GoldResponse>()

            val prices = getGoldPrice.gold_prices

            emit(Result.Success(prices))

        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}