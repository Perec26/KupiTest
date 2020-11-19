package com.kupitest.presentation.profile.list

import android.content.Context
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.kupitest.R
import kotlinx.android.synthetic.main.item_info.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class InfoItem(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_info, this)
    }

    @ModelProp
    fun title(@StringRes titleId: Int) {
        tvTitle.setText(titleId)
    }

    @ModelProp
    fun value(value: String) {
        tvValue.text = value
    }

    @ModelProp
    fun showArrow(show: Boolean) {
        ivArrow.isVisible = show
    }

    @CallbackProp
    fun onClick(callback: (() -> Unit)?) {
        setOnClickListener { callback?.invoke() }
    }
}