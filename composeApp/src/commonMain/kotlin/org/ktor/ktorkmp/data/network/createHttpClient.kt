package org.ktor.ktorkmp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val TIME_OUT = 10_000
private const val TAG_KTOR_LOGGER = "ktor_logger:"
private const val TAG_HTTP_STATUS_LOGGER = "http_status:"

fun createHttpClient(engine: HttpClientEngine): HttpClient {

    return HttpClient(engine) {

        install(ResponseObserver) {
            onResponse { response ->

                android.util.Log.d(TAG_HTTP_STATUS_LOGGER, "${response.status.value}")
            }
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    android.util.Log.d(TAG_KTOR_LOGGER, message)
                }

            }

            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }


    }
}