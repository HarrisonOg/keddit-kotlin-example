package com.harrisonog.kedditkotlin.features.news

import com.harrisonog.kedditkotlin.commons.RedditNewsItem
import rx.Observable

/**
 * NewsManager allows you to request more news from reddit
 *
 * Created by harrisonoglesby on 10/17/16.
 */
class NewsManager() {

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->

            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10){
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i,
                        1457207701L - i * 200,
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            subscriber.onNext(news)

        }
    }

}