package com.kupitest.data.model

import com.google.gson.annotations.SerializedName

data class ProfileDto(
    @SerializedName("account_id")
    val accountId: String,
    @SerializedName("birth_date")
    val birthDate: String? = null,
    val city: String? = null,
    val country: String? = null,
    val email: String,
    @SerializedName("first_name")
    val firstName: String? = null,
    val gender: String? = null,
    @SerializedName("is_full")
    val isFull: Boolean,
    val lang: String,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("phone_number")
    val phoneNumber: String? = null,
    val vip: Boolean,
    @SerializedName("vip_expired")
    val vipExpired: String? = null
)

fun ProfileDto.toEntity(): ProfileEntity {
    return ProfileEntity(
        accountId,
        birthDate,
        city,
        country,
        email,
        firstName,
        gender,
        isFull,
        lang,
        lastName,
        phoneNumber,
        vip,
        vipExpired
    )
}