package org.ktor.ktorkmp

import androidx.compose.ui.window.ComposeUIViewController
import org.ktor.ktorkmp.app.di.initKoin
import org.ktor.ktorkmp.app.screens.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()

    }
) { App() }