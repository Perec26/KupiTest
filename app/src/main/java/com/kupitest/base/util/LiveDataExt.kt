package com.kupitest.base.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observe(owner: LifecycleOwner, action: (item: T) -> Unit) {
    observe(owner, Observer(action))
}

fun <T> LiveData<T>.safeObserve(owner: LifecycleOwner, action: (item: T) -> Unit) {
    observe(owner, SafeObserver(action))
}