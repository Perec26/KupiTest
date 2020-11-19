package com.kupitest.data.model

import com.kupitest.data.model.BaseAnyDto.Companion.STATUS_SUCCESS

data class BaseAnyDto(
    val data: Any? = null,
    val status: String,
    val reason: String? = null
) {
    companion object {
        const val STATUS_SUCCESS = "success"
    }
}

fun BaseAnyDto.isSuccessful() = status == STATUS_SUCCESS