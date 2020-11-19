package com.kupitest.domain.interactor

import com.kupitest.domain.repository.BooksRepository

class BooksInteractor(
    private val booksRepository: BooksRepository
) {
    suspend fun loadBooks() = booksRepository.loadBooks()
    fun getBooksAsFlow() = booksRepository.getBooksAsFlow()
}