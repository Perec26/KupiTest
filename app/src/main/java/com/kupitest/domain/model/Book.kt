package com.kupitest.domain.model

data class Book(
    val authors: List<String>,
    val id: Int,
    val imageUrl: String?,
    val name: String
)