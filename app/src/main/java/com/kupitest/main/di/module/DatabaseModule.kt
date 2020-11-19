package com.kupitest.main.di.module

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.kupitest.main.db.Database
import org.koin.dsl.binds
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), Database::class.java, "kupi_db")
            .apply {
                getAll<Migration>().forEach { addMigrations(it) }
            }
            .build()
    } binds arrayOf(RoomDatabase::class)
}