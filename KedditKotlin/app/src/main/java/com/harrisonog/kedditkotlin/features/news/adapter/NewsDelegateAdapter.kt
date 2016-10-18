package com.harrisonog.kedditkotlin.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import com.harrisonog.kedditkotlin.commons.RedditNewsItem
import com.harrisonog.kedditkotlin.commons.adapter.ViewType
import com.harrisonog.kedditkotlin.commons.adapter.ViewTypeDelegateAdapter
import com.harrisonog.kedditkotlin.commons.extensions.inflate
import com.harrisonog.kedditkotlin.R
import com.harrisonog.kedditkotlin.commons.extensions.getFriendlyTime
import com.harrisonog.kedditkotlin.commons.extensions.loadImg

import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by harrisonoglesby on 10/17/16.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter{

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder (
            parent.inflate(R.layout.news_item)){

        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).intro(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }

}