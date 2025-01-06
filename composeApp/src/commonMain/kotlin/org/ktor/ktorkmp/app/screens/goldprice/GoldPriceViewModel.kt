package org.ktor.ktorkmp.app.screens.goldprice

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ktor.ktorkmp.data.sdk.ItemSDK
import org.ktor.ktorkmp.domain.entity.GoldPrice
import org.ktor.ktorkmp.domain.util.Result

class GoldPriceViewModel(
    private var itemSDK: ItemSDK
): ScreenModel
{

    private var _goldPriceState:MutableStateFlow<Result<List<GoldPrice>>> = MutableStateFlow(Result.Loading())

    val goldPriceState = _goldPriceState.asStateFlow()

    init {
        getGoldPrice()
    }

     fun getGoldPrice(refresh:Boolean = false) {
        screenModelScope.launch {
            itemSDK.getGoldPriceFromCache(refresh)
                .collect{response->

                    when(response)
                    {
                        is Result.Error -> {
                            _goldPriceState.update { Result.Error(response.message) }
                        }
                        is Result.Loading -> {
                            _goldPriceState.update { Result.Loading() }
                        }
                        is Result.Success -> {

                            _goldPriceState.update { Result.Success(response.data!!) }
                        }
                    }
                }


//            currencyPriceRepo.getCurrencyPrice()
//                .collect{response->
//                    when(response)
//                    {
//                        is Result.Error -> {
//                            _currencyPriceState.update { Result.Error(response.message) }
//                        }
//                        is Result.Loading -> {
//                            _currencyPriceState.update { Result.Loading() }
//                        }
//                        is Result.Success -> {
//                            _currencyPriceState.update { Result.Success(response.data!!) }
//                        }
//                    }
//                }
        }
    }
}