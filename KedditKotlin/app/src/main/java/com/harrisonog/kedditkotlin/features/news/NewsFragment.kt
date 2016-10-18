package com.harrisonog.kedditkotlin.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.ActionBarContainer
//import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.harrisonog.kedditkotlin.R
import com.harrisonog.kedditkotlin.commons.extensions.inflate
import com.harrisonog.kedditkotlin.features.news.adapter.NewsAdapter

import kotlinx.android.synthetic.main.news_fragment.*

/**
 * Created by harrisonoglesby on 10/17/16.
 */
class NewsFragment : Fragment() {

    //private var newsList: RecyclerView? = null

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
    }

    private fun initAdapter() {
        if (newsList.adapter == null) {
            newsList.adapter = NewsAdapter()
        }
    }
}