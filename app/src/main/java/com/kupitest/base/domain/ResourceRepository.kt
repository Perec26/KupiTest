package com.kupitest.base.domain

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.IntegerRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface ResourceRepository {
    fun getColor(@ColorRes resId: Int): Int
    fun getString(@StringRes resId: Int, vararg arguments: Any): String
    fun getQuantityString(@PluralsRes pluralsId: Int, quantity: Int, vararg args: Any): String
    fun getDrawable(@DrawableRes drawable: Int): Drawable?
    fun getAppCompatDrawable(@DrawableRes drawable: Int): Drawable?
    fun getDimen(@DimenRes dimen: Int): Int
    fun getStringArray(@ArrayRes array: Int): List<String>
    fun getIntArray(@ArrayRes array: Int): List<Int>
    fun getResourceIdsArray(@ArrayRes array: Int): List<Int>
    fun getInteger(@IntegerRes id: Int): Int
    fun getResourceId(name: String, type: String): Int?
    fun getFont(@FontRes id: Int): Typeface?
    fun getPackageName(): String
}