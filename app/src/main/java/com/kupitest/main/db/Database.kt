package com.kupitest.main.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kupitest.data.model.BookEntity
import com.kupitest.data.model.ProfileEntity
import com.kupitest.data.source.dao.BooksDao
import com.kupitest.data.source.dao.ProfileDao

@Database(
    entities = [ProfileEntity::class, BookEntity::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun booksDao(): BooksDao
}