package com.harrisonog.kedditkotlin.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by harrisonoglesby on 10/17/16.
 */

class RestAPI() {

    private val redditApi: RedditApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("htttps://www.reddit.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        redditApi = retrofit.create(RedditApi::class.java)
    }

    fun getNews(after: String, limit: String): Call<RedditNewsResponse>{
        return redditApi.getTop(after, limit)
    }
}