package org.ktor.ktorkmp.app.screens.currencyprice

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.ktor.ktorkmp.app.components.CurrencyPriceItem
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.domain.util.Result

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CurrencyPriceScreen()
{
    val currencyPriceViewModel:CurrencyPriceViewModel = koinViewModel()

    val currencyState by currencyPriceViewModel.currencyPriceState.collectAsState()

    CurrencyPriceContent(currencyState)
}

@Composable
fun CurrencyPriceContent(currencyState: Result<List<CurrencyPriceModel>>)
{
    when(currencyState)
    {
        is Result.Error -> {

        }
        is Result.Loading -> {
            CircularProgressIndicator()
        }
        is Result.Success -> {

            LazyColumn {
                items(currencyState.data!!)
                {
                    CurrencyPriceItem(
                        item = it
                    )
                }
            }
        }
    }
}