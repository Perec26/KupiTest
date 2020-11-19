package com.kupitest.presentation.books.list

import com.airbnb.epoxy.TypedEpoxyController
import com.kupitest.presentation.books.model.BookUi

class BookController : TypedEpoxyController<List<BookUi>>() {
    override fun buildModels(data: List<BookUi>) {
        data.forEach { book ->
            bookItem {
                id(book.id)
                title(book.name)
                authors(book.authors)
                image(book.url)
            }
        }
    }
}