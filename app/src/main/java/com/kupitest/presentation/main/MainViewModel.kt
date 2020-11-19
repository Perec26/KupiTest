package com.kupitest.presentation.main

import com.kupitest.base.presentation.BaseViewModel
import com.kupitest.main.navigation.MainNavigator

class MainViewModel(
    private val navigator: MainNavigator
) : BaseViewModel() {

    init {
        navigator.toProfile()
    }
}