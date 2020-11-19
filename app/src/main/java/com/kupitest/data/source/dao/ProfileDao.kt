package com.kupitest.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.kupitest.data.model.PROFILE_TABLE
import com.kupitest.data.model.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertProfile(profile: ProfileEntity)

    @Query("SELECT * FROM $PROFILE_TABLE")
    abstract fun getProfileAsFlow(): Flow<ProfileEntity?>

    @Query("DELETE FROM $PROFILE_TABLE")
    abstract suspend fun deleteProfile()

    @Transaction
    open suspend fun saveProfile(profile: ProfileEntity) {
        deleteProfile()
        insertProfile(profile)
    }

}