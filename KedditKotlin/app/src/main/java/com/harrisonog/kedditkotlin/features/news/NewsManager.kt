package com.harrisonog.kedditkotlin.features.news


import com.harrisonog.kedditkotlin.commons.RedditNewsItem
import com.harrisonog.kedditkotlin.api.NewsRestAPI
import com.harrisonog.kedditkotlin.api.NewsAPI
import com.harrisonog.kedditkotlin.commons.RedditNews

import rx.Observable

/**
 * NewsManager allows you to request more news from reddit
 *
 * Created by harrisonoglesby on 10/17/16.
 */
class NewsManager(private val api: NewsAPI = NewsRestAPI()) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->

            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created,
                            item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news)
                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }

        }
    }

}