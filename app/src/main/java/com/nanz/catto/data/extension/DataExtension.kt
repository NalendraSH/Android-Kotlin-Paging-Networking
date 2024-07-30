package com.nanz.catto.data.extension

import android.util.Log
import com.nanz.catto.BuildConfig

fun Any?.isNull(): Boolean = this == null

fun Any?.isNotNull(): Boolean = !this.isNull()

fun Any?.isNull(
    block: () -> Unit
): Boolean {

    if (this == null) {
        block.invoke()
        return true
    }

    return false
}

fun Any?.isNotNull(
    block: () -> Unit
): Boolean {
    if (this != null) {
        block.invoke()
        return true
    }

    return false
}

fun Any.logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(this::class.java.name, message)
    }
}