package com.kupitest.main

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.kupitest.main.di.module.booksModule
import com.kupitest.main.di.module.databaseModule
import com.kupitest.main.di.module.mainModule
import com.kupitest.main.di.module.navigationModule
import com.kupitest.main.di.module.networkModule
import com.kupitest.main.di.module.profileModule
import com.kupitest.main.di.module.resourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        Timber.plant(Timber.DebugTree())
        initDi()
    }

    private fun initDi() {
        startKoin {
            androidContext(this@MainApplication)
            modules(
                networkModule,
                databaseModule,
                navigationModule,
                resourceModule,
                profileModule,
                mainModule,
                booksModule
            )
        }
    }
}