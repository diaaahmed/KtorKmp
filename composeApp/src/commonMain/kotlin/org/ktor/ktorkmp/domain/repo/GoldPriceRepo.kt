package org.ktor.ktorkmp.domain.repo

import kotlinx.coroutines.flow.Flow
import org.ktor.ktorkmp.domain.entity.GoldPrice
import org.ktor.ktorkmp.domain.util.Result

interface GoldPriceRepo
{
    suspend fun getGoldsData():Flow<Result<List<GoldPrice>>>

}