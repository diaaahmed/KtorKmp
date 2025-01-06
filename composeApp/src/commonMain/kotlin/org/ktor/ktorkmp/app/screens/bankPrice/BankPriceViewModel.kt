package org.ktor.ktorkmp.app.screens.bankPrice

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ktor.ktorkmp.data.sdk.ItemSDK
import org.ktor.ktorkmp.domain.entity.BankPrice
import org.ktor.ktorkmp.domain.util.Result

class BankPriceViewModel(
    private var itemSDK: ItemSDK
): ScreenModel
{

    private var _bankPriceState:MutableStateFlow<Result<List<BankPrice>>> = MutableStateFlow(Result.Loading())

    val bankPriceState = _bankPriceState.asStateFlow()

    init {
        getGoldPrice()
    }

     fun getGoldPrice(refresh:Boolean = false) {
        screenModelScope.launch {
            itemSDK.getBankPriceFromCache(refresh)
                .collect{response->

                    when(response)
                    {
                        is Result.Error -> {
                            _bankPriceState.update { Result.Error(response.message) }
                        }
                        is Result.Loading -> {
                            _bankPriceState.update { Result.Loading() }
                        }
                        is Result.Success -> {

                            _bankPriceState.update { Result.Success(response.data!!) }
                        }
                    }
                }

        }
    }
}