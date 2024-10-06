package org.ktor.ktorkmp.app.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module
import org.ktor.ktorkmp.data.network.createHttpClient

actual val platFormModule = module {

    single<HttpClientEngine> { Darwin.create() }
    single { createHttpClient(get()) }
}