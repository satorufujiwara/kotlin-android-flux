package jp.satorufujiwara.kotlin.data

import android.app.Fragment
import android.support.v4.app
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment as SupportFragment

fun app.Fragment.inflate(layoutResId: Int, inflater: LayoutInflater?,
        container: ViewGroup?): View? {
    return inflater?.inflate(layoutResId, container, false)
}

fun Fragment.inflate(layoutResId: Int, inflater: LayoutInflater?,
        container: ViewGroup?): View? {
    return inflater?.inflate(layoutResId, container, false)
}



