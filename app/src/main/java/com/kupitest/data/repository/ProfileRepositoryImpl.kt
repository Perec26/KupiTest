package com.kupitest.data.repository

import com.kupitest.data.Token
import com.kupitest.data.model.toDomain
import com.kupitest.data.model.toEntity
import com.kupitest.data.source.api.ProfileApi
import com.kupitest.data.source.dao.ProfileDao
import com.kupitest.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class ProfileRepositoryImpl(
    private val dao: ProfileDao,
    private val api: ProfileApi
) : ProfileRepository {

    override suspend fun loadProfile() {
        val profile = api.getProfile(Token.STANDARD.value).toEntity()
        dao.saveProfile(profile)
    }

    override fun getProfileAsFlow() = dao.getProfileAsFlow().filterNotNull().map { it.toDomain() }
}