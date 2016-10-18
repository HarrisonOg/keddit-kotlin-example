@file:JvmName("ExtensionsUtils")

package com.harrisonog.kedditkotlin.commons.extensions

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.harrisonog.kedditkotlin.R

import com.squareup.picasso.Picasso

/**
 * Created by harrisonoglesby on 10/17/16.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imgUrl: String) {
    if (TextUtils.isEmpty(imgUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.with(context).load(imgUrl).into(this)
    }
}