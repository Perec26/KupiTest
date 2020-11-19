package com.kupitest.data.model

import com.google.gson.annotations.SerializedName

data class ReadBooksDto(
    val authors: List<AuthorDto>,
    val books: List<BookDto>
)

data class AuthorDto(
    @SerializedName("birth_date")
    val birthDate: String?,
    @SerializedName("first_name")
    val firstName: String,
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
)

data class BookDto(
    val authors: List<Int>,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String?,
    val name: String
)

private fun AuthorDto.toName() = "$firstName $lastName"
private fun List<AuthorDto>.toName() = map { it.toName() }

fun BookDto.toEntity(authors: List<String>) = BookEntity(authors, id, imageUrl, name)

fun ReadBooksDto.toEntity(): List<BookEntity> {
    return books.map { book ->
        val authorsNames = book.authors
            .map { authorId -> authors.first { it.id == authorId } }
            .toName()
        book.toEntity(authorsNames)
    }
}