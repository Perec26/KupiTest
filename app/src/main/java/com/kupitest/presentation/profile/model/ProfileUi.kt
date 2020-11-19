package com.kupitest.presentation.profile.model

import com.kupitest.base.util.DateTimeFormats.FORMATTER_DAYS_MONTH_YEAR
import com.kupitest.base.util.toString
import com.kupitest.domain.model.Gender
import com.kupitest.domain.model.Profile

data class ProfileUi(
    val accountId: String,
    val birthDate: String? = null,
    val city: String? = null,
    val country: String? = null,
    val email: String,
    val lastName: String? = null,
    val firstName: String? = null,
    val gender: Gender? = null,
    val phoneNumber: String? = null,
    val booksCount: String = "0"
)

fun Profile.toUi(booksCount: Int = 0): ProfileUi {
    return ProfileUi(
        accountId,
        birthDate?.toString(FORMATTER_DAYS_MONTH_YEAR),
        city,
        country,
        email,
        firstName,
        lastName,
        gender,
        phoneNumber,
        booksCount.toString()
    )
}