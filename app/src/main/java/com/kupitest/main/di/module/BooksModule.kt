package com.kupitest.main.di.module

import com.kupitest.data.repository.BooksRepositoryImpl
import com.kupitest.data.source.api.BooksApi
import com.kupitest.domain.interactor.BooksInteractor
import com.kupitest.domain.repository.BooksRepository
import com.kupitest.main.db.Database
import com.kupitest.presentation.books.BooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val booksModule = module {
    single { get<Database>().booksDao() }
    single { get<Retrofit>().create(BooksApi::class.java) }
    single<BooksRepository> { BooksRepositoryImpl(get(), get()) }
    single { BooksInteractor(get()) }
    viewModel { BooksViewModel(get(), get()) }
}