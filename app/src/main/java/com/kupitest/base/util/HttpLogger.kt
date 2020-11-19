package com.kupitest.base.util

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

internal class HttpLogger : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        Timber.tag("HttpLogger").d(message)
    }
}