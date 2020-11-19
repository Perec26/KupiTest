package com.kupitest.base.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.PluralsRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat

fun Context.getColorKtx(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun Context.getDrawableKtx(@DrawableRes id: Int): Drawable? {
    return AppCompatResources.getDrawable(this, id)
}

fun Context.getColorStateListKtx(@ColorRes id: Int): ColorStateList {
    return AppCompatResources.getColorStateList(this, id)
}

fun Context.getQuantityStringKtx(@PluralsRes id: Int, quantity: Int): String {
    return resources.getQuantityString(id, quantity, quantity)
}

fun Context.getQuantityStringKtx(@PluralsRes id: Int, quantity: Int, value: String): String {
    return resources.getQuantityString(id, quantity, value)
}

fun Context.getDimensionKtx(@DimenRes id: Int): Float {
    return resources.getDimension(id)
}

fun Context.getDimensionPixelSizeKtx(@DimenRes id: Int): Int {
    return resources.getDimensionPixelSize(id)
}

fun Context.copyToClipboard(text: CharSequence) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.hasPermissions(vararg permissions: String) = permissions.all { isPermissionGranted(it) }

fun Context.isPermissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}