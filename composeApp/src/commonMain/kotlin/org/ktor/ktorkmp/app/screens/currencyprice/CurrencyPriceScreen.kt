package org.ktor.ktorkmp.app.screens.currencyprice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.ktor.ktorkmp.app.components.CurrencyPriceItem
import org.ktor.ktorkmp.app.components.MainRow
import org.ktor.ktorkmp.app.screens.goldprice.GoldScreen
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.data.settings.getData
import org.ktor.ktorkmp.data.settings.saveData
import org.ktor.ktorkmp.domain.util.Result

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CurrencyPriceScreen() {

    val scope = rememberCoroutineScope()

    scope.launch {

        println("diaa ${getData().toString()}")
        delay(2000)
        saveData()
        delay(2000)
        println("diaa ${getData().toString()}")
    }

    val navigator = LocalNavigator.current

    val currencyPriceViewModel: CurrencyPriceViewModel = koinViewModel()

    val currencyState by currencyPriceViewModel.currencyPriceState.collectAsState()

    CurrencyPriceContent(currencyState){
        navigator?.push(GoldScreen())
    }
}

@Composable
fun CurrencyPriceContent(
    currencyState: Result<List<CurrencyPriceModel>>,
    onNavigateClick :  () -> Unit = {}
) {

    println("diaa here")

    when (currencyState) {
        is Result.Error -> {
            Text(text = currencyState.message.toString())
        }

        is Result.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Result.Success -> {

            Column {
                Button(onClick = { onNavigateClick() }){
                    Text(text = "Click to gold screen")
                }

                MainRow("العملة")

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
}