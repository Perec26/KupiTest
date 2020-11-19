package com.kupitest.domain.repository

import com.kupitest.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    suspend fun loadBooks()
    fun getBooksAsFlow(): Flow<List<Book>>
}