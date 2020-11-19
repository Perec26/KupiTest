package com.kupitest.main.di.provider

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpClientProvider(
    private val interceptors: List<Interceptor>
) {
    fun provide(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                readTimeout(ALL_TIMEOUTS_CONNECTION, TimeUnit.SECONDS)
                connectTimeout(ALL_TIMEOUTS_CONNECTION, TimeUnit.SECONDS)
                writeTimeout(ALL_TIMEOUTS_CONNECTION, TimeUnit.SECONDS)
                interceptors.forEach { addInterceptor(it) }
            }.build()
    }

    companion object {
        private const val ALL_TIMEOUTS_CONNECTION = 60L
    }
}