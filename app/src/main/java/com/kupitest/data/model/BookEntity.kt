package com.kupitest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.kupitest.domain.model.Book

const val BOOK_TABLE = "book"

@Entity(tableName = BOOK_TABLE)
@TypeConverters(StringListConverter::class)
data class BookEntity(
    val authors: List<String> = listOf(),
    @PrimaryKey
    val id: Int,
    val imageUrl: String? = null,
    val name: String
)

fun BookEntity.toDomain() = Book(authors, id, imageUrl, name)

fun List<BookEntity>.toDomain() = map { it.toDomain() }

class StringListConverter {

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        return value.split(",")
    }
}