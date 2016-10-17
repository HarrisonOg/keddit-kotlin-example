@file:JvmName("ExtensionsUtils")

package com.harrisonog.kedditkotlin.commons

/**
 * Created by harrisonoglesby on 10/17/16.
 */
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}