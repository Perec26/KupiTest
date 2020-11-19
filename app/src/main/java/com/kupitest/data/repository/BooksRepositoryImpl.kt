package com.kupitest.data.repository

import com.kupitest.data.Token
import com.kupitest.data.model.toDomain
import com.kupitest.data.model.toEntity
import com.kupitest.data.source.api.BooksApi
import com.kupitest.data.source.dao.BooksDao
import com.kupitest.domain.repository.BooksRepository
import kotlinx.coroutines.flow.map

class BooksRepositoryImpl(
    private val api: BooksApi,
    private val dao: BooksDao
) : BooksRepository {

    override suspend fun loadBooks() {
        val books = api.getBooks(Token.STANDARD.value).toEntity()
        dao.saveBooks(books)
    }

    override fun getBooksAsFlow() = dao.getBooksAsFlow().map { it.toDomain() }
}