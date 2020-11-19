package com.kupitest.base.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kupitest.R
import com.kupitest.main.network.ApiException
import com.kupitest.main.network.ApiUnknownException
import timber.log.Timber

abstract class BaseFragment : Fragment() {
    abstract val layoutResId: Int
    abstract val viewModel: BaseViewModel?
    protected open val title: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutResId, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel?.error?.observe(viewLifecycleOwner) { showError(it) }
    }

    private fun showError(error: Throwable?) {
        if (error == null) return
        Timber.e(error)
        val unknownError = requireContext().getString(R.string.unknown_error)
        val errorMessage = when (error) {
            is ApiException -> requireContext().getString(R.string.error, error.reason)
            is ApiUnknownException -> requireContext().getString(error.reasonRes)
            else -> unknownError
        }
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
    }

    open fun onBackPressed(): Boolean = false
}