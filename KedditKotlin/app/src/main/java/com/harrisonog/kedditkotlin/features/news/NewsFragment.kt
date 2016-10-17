package com.harrisonog.kedditkotlin.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.ActionBarContainer
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.harrisonog.kedditkotlin.R
import com.harrisonog.kedditkotlin.commons.inflate


/**
 * Created by harrisonoglesby on 10/17/16.
 */
class NewsFragment : Fragment() {

    private var newsList: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        //val view = inflater.inflate(R.layout.news_fragment, container, false)
        val view = container?.inflate(R.layout.news_fragment)
        newsList = view?.findViewById(R.id.news_list) as RecyclerView?
        newsList?.setHasFixedSize(true) //use this setting to improve performance
        newsList?.layoutManager = LinearLayoutManager(context)

        return view
    }


}