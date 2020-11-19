package com.kupitest.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kupitest.R
import com.kupitest.base.util.safeObserve
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private val cicerone by inject<Cicerone<Router>>()

    private val navigator: Navigator by lazy {
        SupportAppNavigator(this, supportFragmentManager, R.id.fcvContainer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.error.safeObserve(this) { Timber.d(it) }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.navigatorHolder.removeNavigator()
    }
}