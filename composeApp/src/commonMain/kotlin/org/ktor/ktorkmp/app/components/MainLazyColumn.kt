package org.ktor.ktorkmp.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.domain.entity.BankPrice
import org.ktor.ktorkmp.domain.entity.GoldPrice

@Composable
fun MainLazyColumn(
    modifier:Modifier = Modifier,
    list:List<Any>
)
{
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(14.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(list)
        {item->
            when(item)
            {
                is CurrencyPriceModel -> {
                    CurrencyPriceItem(item = item)
                }

                is GoldPrice -> {
                    GoldPriceItem(item = item)
                }

                is BankPrice -> {
                    BankPriceItem(item = item)
                }

            }
        }
    }
}