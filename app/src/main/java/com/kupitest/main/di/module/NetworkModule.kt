package com.kupitest.main.di.module

import com.google.gson.GsonBuilder
import com.kupitest.base.util.HttpLogger
import com.kupitest.main.di.provider.OkHttpClientProvider
import com.kupitest.main.di.provider.RetrofitProvider
import com.kupitest.main.network.ApiErrorInterceptor
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<HttpLoggingInterceptor.Logger> { HttpLogger() }
    factory {
        HttpLoggingInterceptor(get()).apply { level = HttpLoggingInterceptor.Level.BODY }
    } bind Interceptor::class
    factory { ApiErrorInterceptor(get()) } bind Interceptor::class
    single { GsonBuilder().create() }
    single { OkHttpClientProvider(getAll()).provide() }
    single<Converter.Factory> { GsonConverterFactory.create(get()) }
    single { RetrofitProvider(get(), get()).provide() }
}