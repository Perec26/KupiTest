package com.kupitest.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.kupitest.data.model.BOOK_TABLE
import com.kupitest.data.model.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertBooks(books: List<BookEntity>)

    @Query("SELECT * FROM $BOOK_TABLE")
    abstract fun getBooksAsFlow(): Flow<List<BookEntity>>

    @Query("DELETE FROM $BOOK_TABLE")
    abstract suspend fun deleteBooks()

    @Transaction
    open suspend fun saveBooks(books: List<BookEntity>) {
        deleteBooks()
        insertBooks(books)
    }
}