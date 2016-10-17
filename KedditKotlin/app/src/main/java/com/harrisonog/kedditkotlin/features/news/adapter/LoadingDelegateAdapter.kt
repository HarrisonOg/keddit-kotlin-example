package com.harrisonog.kedditkotlin.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewParent

import com.harrisonog.kedditkotlin.commons.adapter.ViewType
import com.harrisonog.kedditkotlin.commons.adapter.ViewTypeDelegateAdapter
import com.harrisonog.kedditkotlin.R
import com.harrisonog.kedditkotlin.commons.inflate

/**
 * Created by harrisonoglesby on 10/17/16.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter{

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}