package com.kupitest.presentation.profile

import androidx.lifecycle.MutableLiveData
import com.kupitest.R
import com.kupitest.base.domain.ResourceInteractor
import com.kupitest.base.presentation.BaseViewModel
import com.kupitest.domain.interactor.BooksInteractor
import com.kupitest.domain.interactor.ProfileInteractor
import com.kupitest.domain.model.Gender
import com.kupitest.main.navigation.MainNavigator
import com.kupitest.presentation.profile.model.InfoUi
import com.kupitest.presentation.profile.model.ProfileUi
import com.kupitest.presentation.profile.model.toUi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine

class ProfileViewModel(
    private val navigator: MainNavigator,
    private val profileIterator: ProfileInteractor,
    private val booksInteractor: BooksInteractor,
    private val resourceInteractor: ResourceInteractor
) : BaseViewModel() {

    val infos = MutableLiveData<List<InfoUi>>()

    init {
        loadData()
        getProfile()
    }

    private fun getProfile() {
        launchErrorJob {
            combine(
                profileIterator.getProfileAsFlow(),
                booksInteractor.getBooksAsFlow()
            ) { profile, books -> profile.toUi(books.size) }
                .collect { profile -> showProfile(profile) }
        }
    }

    private fun showProfile(profile: ProfileUi) {
        val noInfo = resourceInteractor.getString(R.string.no_info)
        val gender = when (profile.gender) {
            Gender.MALE -> resourceInteractor.getString(R.string.male)
            Gender.FEMALE -> resourceInteractor.getString(R.string.female)
            null -> noInfo
        }
        with(profile) {
            infos.value = listOf(
                InfoUi(R.string.first_name, firstName ?: noInfo),
                InfoUi(R.string.last_name, lastName ?: noInfo),
                InfoUi(R.string.birthday, birthDate ?: noInfo),
                InfoUi(R.string.city, city ?: noInfo),
                InfoUi(R.string.gender, gender),
                InfoUi(R.string.email, email),
                InfoUi(R.string.phone_number, phoneNumber ?: noInfo),
                InfoUi(R.string.books_count, booksCount, true)
            )
        }
    }

    fun loadData() {
        launchLoadingErrorJob {
            profileIterator.loadProfile()
            booksInteractor.loadBooks()
        }
    }

    fun onBooksClick() {
        navigator.toBooks()
    }
}