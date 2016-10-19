package com.harrisonog.kedditkotlin.api

import retrofit2.Call

/**
 * Created by harrisonoglesby on 10/19/16.
 */
interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}