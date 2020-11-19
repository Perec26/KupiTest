package com.kupitest.data.source.api

import com.kupitest.data.model.ProfileDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileApi {
    @GET("{token}%2Fprofile.json?alt=media")
    suspend fun getProfile(@Path("token") token: String): ProfileDto
}