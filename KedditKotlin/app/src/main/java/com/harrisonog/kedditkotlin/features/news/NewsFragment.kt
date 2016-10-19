package com.harrisonog.kedditkotlin.features.news

import android.os.Bundle
import android.widget.Toast
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.harrisonog.kedditkotlin.R
import com.harrisonog.kedditkotlin.commons.InfiniteScrollListener
import com.harrisonog.kedditkotlin.commons.RedditNews
import com.harrisonog.kedditkotlin.commons.RxBaseFragment
import com.harrisonog.kedditkotlin.commons.extensions.inflate
import com.harrisonog.kedditkotlin.features.news.adapter.NewsAdapter

import kotlinx.android.synthetic.main.news_fragment.*

import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by harrisonoglesby on 10/17/16.
 */
class NewsFragment : RxBaseFragment() {

    companion object {
        private val KEY_REDDIT_NEWS = "redditNews"
    }

    private var redditNews: RedditNews? = null
    private val newsManager by lazy { NewsManager() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        }

        initAdapter()

        if (savedInstanceState == null && savedInstanceState.containsKey(KEY_REDDIT_NEWS)) {
            redditNews = savedInstanceState.get(KEY_REDDIT_NEWS) as RedditNews
            (news_list.adapter as NewsAdapter).clearAndAddNews(redditNews!!.news)
            requestNews()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val news = (news_list.adapter as NewsAdapter).getNews()
        if (redditNews != null && news.size > 0){
            outState.putParcelable(KEY_REDDIT_NEWS, redditNews?.copy(news = news))
        }
    }

    private fun requestNews() {
        // (news_list.adapter as NewsAdapter).addNews(news)
        /**
         * Empty after String for now
         */
        val subscription = newsManager.getNews(redditNews?.after ?: "")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    {  retrievedNews ->
                        redditNews = retrievedNews
                        (news_list.adapter as NewsAdapter).addNews(retrievedNews.news)
                    },
                    {  e ->
                        Toast.makeText(context, e.message ?: "", Toast.LENGTH_LONG).show()
                    }
            )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}