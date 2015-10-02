package jp.satorufujiwara.kotlin.util.ext

import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment as SupportFragment

fun SupportFragment.inflate(layoutResId: Int, inflater: LayoutInflater?,
        container: ViewGroup?): View? =
        inflater?.inflate(layoutResId, container, false)

fun Fragment.inflate(layoutResId: Int, inflater: LayoutInflater?,
        container: ViewGroup?): View? =
        inflater?.inflate(layoutResId, container, false)



