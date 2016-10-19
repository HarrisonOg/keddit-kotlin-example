package com.harrisonog.kedditkotlin.commons

import com.harrisonog.kedditkotlin.commons.adapter.AdapterConstants
import com.harrisonog.kedditkotlin.commons.adapter.ViewType

/**
 * Created by harrisonoglesby on 10/17/16.
 */
data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}

data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>)