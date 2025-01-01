package org.ktor.ktorkmp.app.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.ktor.ktorkmp.app.screens.currencyprice.CurrencyPriceViewModel
import org.ktor.ktorkmp.data.local.LocalDatabase
import org.ktor.ktorkmp.data.repo.CurrencyPriceRepoImpl
import org.ktor.ktorkmp.data.sdk.ItemSDK
import org.ktor.ktorkmp.domain.repo.CurrencyPriceRepo

expect val platFormModule:Module

val sharedModule = module {

    single<CurrencyPriceRepo> { CurrencyPriceRepoImpl(get()) }

    single<ItemSDK> { ItemSDK(get(),get()) }

    single<LocalDatabase> { LocalDatabase(get()) }

    single{ CurrencyPriceViewModel(currencyPriceRepo = get(), itemSDK = get() ) }

}