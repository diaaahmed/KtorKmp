package org.ktor.ktorkmp.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.ktor.ktorkmp.app.di.initKoin

class MyApplication: Application()
{
    override fun onCreate() {
        super.onCreate()

        initKoin{
            androidContext(this@MyApplication)
        }
    }
}