package org.ktor.ktorkmp.domain.repo

import kotlinx.coroutines.flow.Flow
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.domain.util.Result

interface CurrencyPriceRepo
{
    suspend fun getCurrencyPrice():Flow<Result<List<CurrencyPriceModel>>>
}