package com.kupitest.main.di.module

import com.kupitest.base.data.ResourceRepositoryImpl
import com.kupitest.base.domain.ResourceInteractor
import com.kupitest.base.domain.ResourceRepository
import org.koin.dsl.module

val resourceModule = module {
    factory { ResourceInteractor(get()) }
    single<ResourceRepository> { ResourceRepositoryImpl(get()) }
}