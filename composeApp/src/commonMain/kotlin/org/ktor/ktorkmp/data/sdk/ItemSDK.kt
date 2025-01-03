package org.ktor.ktorkmp.data.sdk

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ktor.ktorkmp.data.local.LocalDatabase
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.domain.repo.CurrencyPriceRepo
import org.ktor.ktorkmp.domain.util.Result

class ItemSDK(
    private val localDatabase: LocalDatabase,
    private val apiRepo: CurrencyPriceRepo
) {

    @Throws(Exception::class)
    suspend fun getDataFromAPiAndInsertInCache(): Flow<Result<List<CurrencyPriceModel>>> = flow {

        try {
            if(localDatabase.readAllItems().isEmpty())
            {
                println("Diaa load data from internet")

                apiRepo.getCurrencyPrice()
                    .collect{currencyResponse->
                        when(currencyResponse){
                            is Result.Error -> {
                                emit(Result.Error(currencyResponse.message.toString()))
                            }
                            is Result.Loading -> {
                                emit(Result.Loading())

                            }
                            is Result.Success -> {
                                localDatabase.removeAllItems()
                                    .also {
                                        localDatabase.insertItem(currencyResponse.data!!)
                                        val localDate = localDatabase.readAllItems()
                                        emit(Result.Success(localDate))
                                    }
                            }
                        }
                    }
            }else{
                emit(Result.Success(localDatabase.readAllItems()))
                println("Diaa load data from cache")
            }


        }catch (e: Exception){
            emit(Result.Error(e.message.toString()))
        }
    }
}