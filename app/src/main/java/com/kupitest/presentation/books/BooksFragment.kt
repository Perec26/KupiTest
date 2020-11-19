package com.kupitest.presentation.books

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.kupitest.R
import com.kupitest.base.presentation.BaseFragment
import com.kupitest.presentation.books.list.BookController
import com.kupitest.presentation.books.model.BookUi
import kotlinx.android.synthetic.main.fragment_books.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksFragment : BaseFragment() {
    override val layoutResId = R.layout.fragment_books
    override val viewModel by viewModel<BooksViewModel>()

    private val controller by lazy { BookController() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.books.observe(viewLifecycleOwner) { showBooks(it) }
        viewModel.loading.observe(viewLifecycleOwner) { srlSwipe.isRefreshing = it }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ervBooks.setController(controller)
        srlSwipe.setOnRefreshListener { viewModel.loadData() }
        toolbar.setNavigationOnClickListener { viewModel.onBackPressed() }
    }

    private fun showBooks(books: List<BookUi>) {
        tvNoBooks.isVisible = books.isEmpty()
        controller.setData(books)
    }
}