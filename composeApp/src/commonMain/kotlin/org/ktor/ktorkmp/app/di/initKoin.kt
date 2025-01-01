package org.ktor.ktorkmp.app.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: (KoinApplication.() -> Unit)? = null)
{
    startKoin{
        config?.invoke(this)
        modules(sharedModule, platFormModule)
    }
}


//fun initKoin(config: KoinAppDeclaration?= null)
//{
//    startKoin{
//        config?.invoke(this)
//        modules(sharedModule, platFormModule)
//    }
//}