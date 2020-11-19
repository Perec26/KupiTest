package com.kupitest.base.domain

import android.graphics.Color
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

class ResourceInteractor(
    private val resourceRepository: ResourceRepository
) {

    fun getColor(@ColorRes resId: Int): Int {
        return resourceRepository.getColor(resId)
    }

    fun getString(@StringRes resId: Int, vararg arguments: Any): String {
        return resourceRepository.getString(resId, *arguments)
    }

    fun getQuantityString(@PluralsRes pluralsId: Int, quantity: Int, vararg args: Any): String {
        return resourceRepository.getQuantityString(pluralsId, quantity, *args)
    }

    fun getQuantityString(@PluralsRes pluralsId: Int, quantity: Int): String {
        return resourceRepository.getQuantityString(pluralsId, quantity, quantity)
    }

    fun getDrawable(@DrawableRes drawable: Int): Drawable? {
        return resourceRepository.getDrawable(drawable)
    }

    fun getAppCompatDrawable(@DrawableRes drawable: Int): Drawable? {
        return resourceRepository.getAppCompatDrawable(drawable)
    }

    fun getDimen(@DimenRes dimen: Int): Int {
        return resourceRepository.getDimen(dimen)
    }

    fun getStringArray(@ArrayRes array: Int): List<String> {
        return resourceRepository.getStringArray(array)
    }

    fun getIntArray(@ArrayRes array: Int): List<Int> {
        return resourceRepository.getIntArray(array)
    }

    fun getResourcesArray(@ArrayRes array: Int): List<Int> {
        return resourceRepository.getResourceIdsArray(array)
    }

    fun getInteger(@IntegerRes id: Int): Int {
        return resourceRepository.getInteger(id)
    }

    fun getResourceId(name: String, type: String): Int? {
        return resourceRepository.getResourceId(name, type)
    }

    fun getFont(@FontRes id: Int): Typeface? {
        return resourceRepository.getFont(id)
    }

    fun getPackageName(): String {
        return resourceRepository.getPackageName()
    }

    fun parseColor(color: String?): Int? {
        return try {
            Color.parseColor(color ?: return null)
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}