package com.kupitest.presentation.profile.list

import com.airbnb.epoxy.TypedEpoxyController
import com.kupitest.presentation.profile.model.InfoUi

class InfoController(
    private val onBooksCountClick: () -> Unit
) : TypedEpoxyController<List<InfoUi>>() {
    override fun buildModels(data: List<InfoUi>) {
        data.forEach {
            infoItem {
                id(it.title)
                title(it.title)
                value(it.value)
                showArrow(it.isBooks)
                if (it.isBooks) onClick { onBooksCountClick() }
            }
        }
    }

}