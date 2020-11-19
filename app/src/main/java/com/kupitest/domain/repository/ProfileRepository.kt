package com.kupitest.domain.repository

import com.kupitest.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun loadProfile()
    fun getProfileAsFlow(): Flow<Profile>
}