package org.ktor.ktorkmp.app.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.dsl.module

import org.ktor.ktorkmp.data.network.createHttpClient

actual val platFormModule = module {

    single<HttpClientEngine> { OkHttp.create() }

    single { createHttpClient(get()) }

}


