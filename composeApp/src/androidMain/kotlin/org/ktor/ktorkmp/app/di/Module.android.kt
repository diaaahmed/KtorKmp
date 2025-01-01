package org.ktor.ktorkmp.app.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.ktor.ktorkmp.data.local.AndroidDatabaseDriverFactory
import org.ktor.ktorkmp.data.local.DatabaseDriverFactory
import org.ktor.ktorkmp.data.network.createHttpClient
import org.ktor.ktorkmp.data.repo.CurrencyPriceRepoImpl

actual val platFormModule = module {

    single<HttpClientEngine> { OkHttp.create() }

    single { createHttpClient(get()) }
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(androidContext()) }

}


