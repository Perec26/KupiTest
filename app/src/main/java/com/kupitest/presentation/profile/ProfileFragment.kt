package com.kupitest.presentation.profile

import android.os.Bundle
import android.view.View
import com.kupitest.R
import com.kupitest.base.presentation.BaseFragment
import com.kupitest.presentation.profile.list.InfoController
import com.kupitest.presentation.profile.model.InfoUi
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment() {
    override val layoutResId = R.layout.fragment_profile
    override val viewModel by viewModel<ProfileViewModel>()

    private val controller by lazy { InfoController { viewModel.onBooksClick() } }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.infos.observe(viewLifecycleOwner) { showInfo(it) }
        viewModel.loading.observe(viewLifecycleOwner) { srlSwipe.isRefreshing = it }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ervInfos.setController(controller)
        srlSwipe.setOnRefreshListener { viewModel.loadData() }
    }

    private fun showInfo(infos: List<InfoUi>) {
        controller.setData(infos)
    }
}