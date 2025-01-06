package org.ktor.ktorkmp.app.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.ktor.ktorkmp.app.screens.bankPrice.BankPriceViewModel
import org.ktor.ktorkmp.app.screens.currencyprice.CurrencyPriceViewModel
import org.ktor.ktorkmp.app.screens.goldprice.GoldPriceViewModel
import org.ktor.ktorkmp.data.local.LocalDatabase
import org.ktor.ktorkmp.data.repo.BankPriceRepoImpl
import org.ktor.ktorkmp.data.repo.CurrencyPriceRepoImpl
import org.ktor.ktorkmp.data.repo.GoldPriceRepoImpl
import org.ktor.ktorkmp.data.sdk.ItemSDK
import org.ktor.ktorkmp.domain.repo.BankPriceRepo
import org.ktor.ktorkmp.domain.repo.CurrencyPriceRepo
import org.ktor.ktorkmp.domain.repo.GoldPriceRepo

expect val platFormModule: Module

val sharedModule = module {

    single<CurrencyPriceRepo> { CurrencyPriceRepoImpl(get()) }

    single<GoldPriceRepo> { GoldPriceRepoImpl(get()) }
    single<BankPriceRepo> { BankPriceRepoImpl(get()) }

    single<ItemSDK> { ItemSDK(get(), get(), get(), get() )}

    single<LocalDatabase> { LocalDatabase(get()) }

    //single{ CurrencyPriceViewModel(currencyPriceRepo = get(), itemSDK = get() ) }
    factory { CurrencyPriceViewModel(currencyPriceRepo = get(), itemSDK = get()) }
    factory { GoldPriceViewModel(itemSDK = get()) }
    factory { BankPriceViewModel(itemSDK = get()) }

}