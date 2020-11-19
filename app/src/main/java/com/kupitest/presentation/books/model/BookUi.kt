package com.kupitest.presentation.books.model

import com.kupitest.domain.model.Book

data class BookUi(
    val id: Int,
    val name: String,
    val authors: String,
    val url: String? = null
)

fun Book.toUi() = BookUi(id, name, authors.joinToString(), imageUrl)

fun List<Book>.toUi() = map { it.toUi() }