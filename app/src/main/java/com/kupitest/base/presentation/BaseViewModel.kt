package com.kupitest.base.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kupitest.base.util.MediatorSingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {

    open val error = MediatorSingleLiveEvent<Throwable?>()
    open val loading = MutableLiveData<Boolean>()

    init {
        Timber.d("${javaClass.name} init")
    }

    override fun onCleared() {
        Timber.d("${javaClass.name} cleared")

        super.onCleared()
        viewModelScope.coroutineContext.cancel()
    }

    open fun onBackPressed() {
        // nothing
    }

    protected fun createExceptionHandler(exceptionBlock: ((Throwable) -> Unit)? = null): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
            exceptionBlock?.invoke(exception)
            postError(exception)
        }
    }

    protected fun launchLoadingErrorJob(
        onError: ((Throwable) -> Unit)? = null,
        jobToDo: suspend () -> Unit
    ): Job {
        return viewModelScope.launch(createExceptionHandler(onError)) {
            try {
                postError(null)
                postLoading(true)
                jobToDo.invoke()
            } finally {
                postLoading(false)
            }
        }
    }

    protected fun launchErrorJob(
        onError: ((Throwable) -> Unit)? = null,
        jobToDo: suspend () -> Unit
    ): Job {
        return viewModelScope.launch(createExceptionHandler(onError)) {
            postError(null)
            jobToDo.invoke()
        }
    }

    protected fun <T> asyncError(
        onError: ((Throwable) -> Unit)? = null,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        jobToDo: suspend () -> T
    ): Deferred<T> {
        return viewModelScope.async(createExceptionHandler(onError), start) {
            postError(null)
            jobToDo.invoke()
        }
    }

    protected open fun postError(throwable: Throwable?) {
        error.postValue(throwable)
    }

    protected open fun postLoading(isLoading: Boolean) {
        loading.postValue(isLoading)
    }
}