package com.kupitest.base.data

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import com.kupitest.base.domain.ResourceRepository
import com.kupitest.base.util.getColorKtx
import com.kupitest.base.util.getDrawableKtx

class ResourceRepositoryImpl(
    private val context: Context
) : ResourceRepository {

    override fun getColor(@ColorRes resId: Int): Int {
        return context.getColorKtx(resId)
    }

    override fun getString(@StringRes resId: Int, vararg arguments: Any): String {
        return context.getString(resId, *arguments)
    }

    override fun getQuantityString(@PluralsRes pluralsId: Int, quantity: Int, vararg args: Any): String {
        return context.resources.getQuantityString(pluralsId, quantity, *args)
    }

    override fun getDrawable(drawable: Int): Drawable? {
        return context.getDrawableKtx(drawable)
    }

    override fun getAppCompatDrawable(drawable: Int): Drawable? {
        return AppCompatResources.getDrawable(context, drawable)
    }

    override fun getDimen(dimen: Int): Int {
        return context.resources.getDimensionPixelSize(dimen)
    }

    override fun getStringArray(array: Int): List<String> {
        return context.resources.getStringArray(array).toList()
    }

    override fun getIntArray(array: Int): List<Int> {
        return context.resources.getIntArray(array).toList()
    }

    override fun getResourceIdsArray(array: Int): List<Int> {
        val typedArray = context.resources.obtainTypedArray(array)
        val resIds = (0 until typedArray.length()).map { index ->
            typedArray.getResourceId(index, 0)
        }
        typedArray.recycle()
        return resIds
    }

    override fun getInteger(id: Int): Int {
        return context.resources.getInteger(id)
    }

    override fun getResourceId(name: String, type: String): Int? {
        return context.resources.getIdentifier(name, type, context.packageName)
    }

    override fun getFont(id: Int): Typeface? {
        return ResourcesCompat.getFont(context, id)
    }

    override fun getPackageName(): String {
        return context.packageName
    }
}