package com.kupitest.presentation.profile.model

import androidx.annotation.StringRes

data class InfoUi(
    @StringRes
    val title: Int,
    val value: String,
    val isBooks: Boolean = false
)