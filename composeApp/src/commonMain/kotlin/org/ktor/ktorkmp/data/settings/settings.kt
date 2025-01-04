package org.ktor.ktorkmp.data.settings

import com.russhwolf.settings.Settings

val settings: Settings = Settings()

fun saveData()
{
    settings.putInt("key", 51)

}

fun getData():Int
{
    return settings.getInt("key", defaultValue = -1)
}
