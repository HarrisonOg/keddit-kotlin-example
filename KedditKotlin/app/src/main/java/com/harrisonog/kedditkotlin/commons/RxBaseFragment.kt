package com.harrisonog.kedditkotlin.commons

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by harrisonoglesby on 10/17/16.
 */
open class RxBaseFragment() : Fragment(){

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if (!subscriptions.isUnsubscribed) {
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }
}