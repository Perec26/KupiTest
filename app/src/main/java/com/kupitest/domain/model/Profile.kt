package com.kupitest.domain.model

import org.threeten.bp.LocalDate

data class Profile(
    val accountId: String,
    val birthDate: LocalDate? = null,
    val city: String? = null,
    val country: String? = null,
    val email: String,
    val firstName: String? = null,
    val gender: Gender? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null
)

enum class Gender { MALE, FEMALE }