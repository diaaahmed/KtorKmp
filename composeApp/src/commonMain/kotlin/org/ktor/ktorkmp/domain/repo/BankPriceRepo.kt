package org.ktor.ktorkmp.domain.repo

import kotlinx.coroutines.flow.Flow
import org.ktor.ktorkmp.domain.entity.BankPrice
import org.ktor.ktorkmp.domain.util.Result

interface BankPriceRepo
{
    suspend fun getBankPrice():Flow<Result<List<BankPrice>>>
}