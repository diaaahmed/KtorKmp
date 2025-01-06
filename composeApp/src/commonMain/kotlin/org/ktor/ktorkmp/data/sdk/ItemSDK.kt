package org.ktor.ktorkmp.data.sdk

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ktor.ktorkmp.data.local.LocalDatabase
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.domain.entity.GoldPrice
import org.ktor.ktorkmp.domain.repo.CurrencyPriceRepo
import org.ktor.ktorkmp.domain.repo.GoldPriceRepo
import org.ktor.ktorkmp.domain.util.Result

class ItemSDK(
    private val localDatabase: LocalDatabase,
    private val apiRepo: CurrencyPriceRepo,
    private val goldRepo: GoldPriceRepo
) {

    @Throws(Exception::class)
    suspend fun getCurrencyPriceFromCache(): Flow<Result<List<CurrencyPriceModel>>> = flow {

        try {
            if (localDatabase.readAllItems().isEmpty()) {
                println("Diaa load data from internet")

                apiRepo.getCurrencyPrice()
                    .collect { currencyResponse ->
                        when (currencyResponse) {
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
            } else {
                emit(Result.Success(localDatabase.readAllItems()))
                println("Diaa load data from cache")
            }


        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    @Throws(Exception::class)
    suspend fun getGoldPriceFromCache(): Flow<Result<List<GoldPrice>>> = flow {

        try {
            if (localDatabase.readAllItemsFromGolds().isEmpty()) {

                goldRepo.getGoldsData()
                    .collect{goldResponse->
                        when(goldResponse){
                            is Result.Error -> {
                                emit(Result.Error(goldResponse.message.toString()))
                            }
                            is Result.Loading -> {
                                emit(Result.Loading())

                            }
                            is Result.Success -> {
                                localDatabase.removeAllItemsFromGolds()
                                    .also {
                                        localDatabase.insertItemToGolds(goldResponse.data!!)
                                        val localDate = localDatabase.readAllItemsFromGolds()
                                        emit(Result.Success(localDate))
                                    }

                              //   emit(Result.Success(goldResponse.data!!))

                            }
                        }
                    }

            } else {
                emit(Result.Success(localDatabase.readAllItemsFromGolds()))

            }

        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

//    @Throws(Exception::class)
//    suspend fun getGoldPriceFromRemote(): Flow<Result<List<GoldPrice>>> = flow {
//
//        try {
//            goldRepo.getGoldsData()
//                .collect{goldResponse->
//                    when(goldResponse){
//                        is Result.Error -> {
//                            emit(Result.Error(goldResponse.message.toString()))
//                        }
//                        is Result.Loading -> {
//                            emit(Result.Loading())
//
//                        }
//                        is Result.Success -> {
//                            emit(Result.Success(goldResponse.data!!))
//
//                        }
//                    }
//                }
//
//        }catch (e: Exception){
//            emit(Result.Error(e.message.toString()))
//        }
//    }
}