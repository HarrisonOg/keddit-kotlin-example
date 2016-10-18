package com.harrisonog.kedditkotlin.features.news


import com.harrisonog.kedditkotlin.commons.RedditNewsItem
import com.harrisonog.kedditkotlin.api.RestAPI

import rx.Observable

/**
 * NewsManager allows you to request more news from reddit
 *
 * Created by harrisonoglesby on 10/17/16.
 */
class NewsManager(private val api: RestAPI = RestAPI()) {

    fun getNews(limit: String = "10"): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->

            val callResponse = api.getNews("", limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val news = response.body().data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created,
                            item.thumbnail, item.url)
                }
                subscriber.onNext(news)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }

//            val news = mutableListOf<RedditNewsItem>()
//            for (i in 1..10){
//                news.add(RedditNewsItem(
//                        "author$i",
//                        "Title $i",
//                        i,
//                        1457207701L - i * 200,
//                        "http://lorempixel.com/200/200/technics/$i", // image url
//                        "url"
//                ))
//            }
//            subscriber.onNext(news)

        }
    }

}