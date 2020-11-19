package com.kupitest.presentation.books.list

import android.content.Context
import android.widget.LinearLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.kupitest.R
import kotlinx.android.synthetic.main.item_book.view.*
import kotlinx.android.synthetic.main.item_info.view.tvTitle

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class BookItem(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_book, this)
    }

    @ModelProp
    fun title(title: String) {
        tvTitle.text = title
    }

    @ModelProp
    fun authors(authors: String) {
        tvAuthors.text = authors
    }

    @ModelProp
    fun image(url: String?) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.ic_image)
            .transition(DrawableTransitionOptions.with { dataSource, isFirstResource ->
                if (dataSource === DataSource.RESOURCE_DISK_CACHE) null
                else DrawableCrossFadeFactory.Builder()
                    .build()
                    .build(dataSource, isFirstResource)
            }
            )
            .into(ivImage)
    }
}