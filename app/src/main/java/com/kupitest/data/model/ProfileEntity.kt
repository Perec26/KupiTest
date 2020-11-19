package com.kupitest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kupitest.base.util.toLocalDate
import com.kupitest.domain.model.Gender
import com.kupitest.domain.model.Profile

const val PROFILE_TABLE = "profile"

@Entity(tableName = PROFILE_TABLE)
data class ProfileEntity(
    @PrimaryKey
    val accountId: String,
    val birthDate: String? = null,
    val city: String? = null,
    val country: String? = null,
    val email: String,
    val firstName: String? = null,
    val gender: String? = null,
    val isFull: Boolean? = null,
    val lang: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val vip: Boolean? = null,
    val vipExpired: String? = null
)

fun ProfileEntity.toDomain(): Profile {
    val gender = when (gender) {
        GENDER_MALE -> Gender.MALE
        GENDER_FEMALE -> Gender.FEMALE
        else -> null
    }
    return Profile(
        accountId,
        birthDate?.toLocalDate(),
        city,
        country,
        email,
        firstName,
        gender,
        lastName,
        phoneNumber
    )
}

private const val GENDER_MALE = "m"
private const val GENDER_FEMALE = "f"

