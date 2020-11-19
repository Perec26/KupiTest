package com.kupitest.main.network

import androidx.annotation.StringRes
import com.kupitest.R
import java.io.IOException

class ApiException(val reason: String) : IOException()

class ApiUnknownException(@StringRes val reasonRes: Int = R.string.unknown_error) : IOException()
