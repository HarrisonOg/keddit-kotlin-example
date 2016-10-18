package com.harrisonog.kedditkotlin.features.news

import android.os.Bundle
import android.widget.Toast
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.harrisonog.kedditkotlin.R
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

    //private var newsList: RecyclerView? = null

    private val newsManager by lazy { NewsManager() }

    private val newsList by lazy {
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        //val view = inflater.inflate(R.layout.news_fragment, container, false)
        //val view = container?.inflate(R.layout.news_fragment)

//        newsList = view?.findViewById(R.id.news_list) as RecyclerView?
//        newsList?.setHasFixedSize(true) //use this setting to improve performance
//        newsList?.layoutManager = LinearLayoutManager(context)

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        // (news_list.adapter as NewsAdapter).addNews(news)
        val subscription = newsManager.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    {  retrievedNews ->
                        (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                    },
                    {  e ->
                        Toast.makeText(context, e.message ?: "", Toast.LENGTH_LONG).show()
                    }
            )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (newsList.adapter == null) {
            newsList.adapter = NewsAdapter()
        }
    }
}