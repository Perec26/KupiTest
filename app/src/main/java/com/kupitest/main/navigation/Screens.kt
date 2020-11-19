package com.kupitest.main.navigation

import com.kupitest.presentation.books.BooksFragment
import com.kupitest.presentation.profile.ProfileFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object ProfileScreen : SupportAppScreen() {
        override fun getFragment() = ProfileFragment()
    }

    object BooksScreen : SupportAppScreen() {
        override fun getFragment() = BooksFragment()
    }
}