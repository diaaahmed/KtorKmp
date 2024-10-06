package org.ktor.ktorkmp.app.screens.currencyprice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.domain.repo.CurrencyPriceRepo
import org.ktor.ktorkmp.domain.util.Result

class CurrencyPriceViewModel(
    private var currencyPriceRepo: CurrencyPriceRepo
): ViewModel()
{

    private var _currencyPriceState:MutableStateFlow<Result<List<CurrencyPriceModel>>> = MutableStateFlow(Result.Loading())

    val currencyPriceState = _currencyPriceState.asStateFlow()

    init {
        getCurrencyPrice()
    }

    private fun getCurrencyPrice()
    {
        viewModelScope.launch {
            currencyPriceRepo.getCurrencyPrice()
                .collect{response->
                    when(response)
                    {
                        is Result.Error -> {
                            _currencyPriceState.update { Result.Error(response.message) }
                        }
                        is Result.Loading -> {
                            _currencyPriceState.update { Result.Loading() }
                        }
                        is Result.Success -> {
                            _currencyPriceState.update { Result.Success(response.data!!) }
                        }
                    }
                }
        }
    }
}