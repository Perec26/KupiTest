package com.kupitest.main.di.module

import com.kupitest.main.navigation.MainNavigator
import com.kupitest.main.navigation.MainNavigatorImpl
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val navigationModule = module {
    single<Cicerone<Router>> { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single<MainNavigator> { MainNavigatorImpl(get()) }
}