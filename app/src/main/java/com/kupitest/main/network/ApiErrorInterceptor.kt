package com.kupitest.main.network

import com.google.gson.Gson
import com.kupitest.data.model.BaseAnyDto
import com.kupitest.data.model.isSuccessful
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class ApiErrorInterceptor(private val gson: Gson) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val response = chain.proceed(chain.request())
            return getDataResponse(response)
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getDataResponse(response: Response): Response {
        val body = response.body ?: throw ApiUnknownException()
        val mediaType = body.contentType()
        val baseResponse = gson.fromJson(body.string(), BaseAnyDto::class.java)
        if (!baseResponse.isSuccessful()) {
            if (baseResponse.reason != null) throw ApiException(baseResponse.reason)
            else throw ApiUnknownException()

        }
        if (baseResponse.data == null) throw ApiUnknownException()
        val dataResponse = gson.toJson(baseResponse.data)
        val dataBody = dataResponse.toResponseBody(mediaType)
        return response.newBuilder().body(dataBody).build()
    }
}