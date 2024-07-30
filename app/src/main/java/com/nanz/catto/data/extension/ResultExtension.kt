package com.nanz.catto.data.extension

import retrofit2.Response

fun Response<*>?.isSuccessAndNotNull(): Boolean = this?.let {
    it.body() != null && it.isSuccessful
} ?: run {
    false
}