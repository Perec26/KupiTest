package com.kupitest.main.navigation

import ru.terrakok.cicerone.Router

class MainNavigatorImpl(private val router: Router) : MainNavigator {
    override fun toProfile() = router.newRootScreen(Screens.ProfileScreen)
    override fun toBooks() = router.navigateTo(Screens.BooksScreen)
    override fun exit() = router.exit()
}