package org.ktor.ktorkmp.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi



//@OptIn(ExperimentalForeignApi::class)
//fun createDataStore(): DataStore<Preferences> {
//    return createDataStore {
//        val directory:NSURL? = NSFileManager.defaultManager.URLForDirectory(
//            directory = NSDocumentDirectory,
//            inDomain = NSUserDomainMask,
//            appropriateForURL = null,
//            create = false,
//            error = null
//        )
//        requireNotNull(directory).path + "/$DATA_STORE_FILE_NAME"
//    }
//}