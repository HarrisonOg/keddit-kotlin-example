package com.harrisonog.kedditkotlin.commons

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
)