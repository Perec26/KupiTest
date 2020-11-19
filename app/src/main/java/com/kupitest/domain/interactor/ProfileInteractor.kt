package com.kupitest.domain.interactor

import com.kupitest.domain.repository.ProfileRepository

class ProfileInteractor(
    private val profileRepository: ProfileRepository
) {
    suspend fun loadProfile() = profileRepository.loadProfile()
    fun getProfileAsFlow() = profileRepository.getProfileAsFlow()
}