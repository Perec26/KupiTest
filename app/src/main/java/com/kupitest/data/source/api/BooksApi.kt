package com.kupitest.data.source.api

import com.kupitest.data.model.ReadBooksDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {
    @GET("{token}%2Fbooks.json?alt=media")
    suspend fun getBooks(@Path("token") token: String): ReadBooksDto
}