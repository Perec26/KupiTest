package com.kupitest.main.di.module

import com.kupitest.data.repository.ProfileRepositoryImpl
import com.kupitest.data.source.api.ProfileApi
import com.kupitest.domain.interactor.ProfileInteractor
import com.kupitest.domain.repository.ProfileRepository
import com.kupitest.main.db.Database
import com.kupitest.presentation.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val profileModule = module {
    single { get<Database>().profileDao() }
    single { get<Retrofit>().create(ProfileApi::class.java) }
    single<ProfileRepository> { ProfileRepositoryImpl(get(), get()) }
    single { ProfileInteractor(get()) }
    viewModel { ProfileViewModel(get(), get(), get(), get()) }
}