package com.kupitest.presentation.books

import androidx.lifecycle.MutableLiveData
import com.kupitest.base.presentation.BaseViewModel
import com.kupitest.domain.interactor.BooksInteractor
import com.kupitest.main.navigation.MainNavigator
import com.kupitest.presentation.books.model.BookUi
import com.kupitest.presentation.books.model.toUi
import kotlinx.coroutines.flow.collect

class BooksViewModel(
    private val navigator: MainNavigator,
    private val booksInteractor: BooksInteractor
) : BaseViewModel() {

    val books = MutableLiveData<List<BookUi>>()

    init {
        launchErrorJob {
            booksInteractor.getBooksAsFlow()
                .collect { books.value = it.toUi() }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        navigator.exit()
    }

    fun loadData() {
        launchLoadingErrorJob {
            booksInteractor.loadBooks()
        }
    }
}