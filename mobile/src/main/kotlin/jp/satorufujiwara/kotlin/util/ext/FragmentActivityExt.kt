package jp.satorufujiwara.kotlin.util.ext

import android.app.Activity
import android.content.res.Configuration
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

fun FragmentActivity.setContentFragment(containerViewId: Int, fragment: Fragment?): Fragment? {
    val f: Fragment? = supportFragmentManager?.findFragmentById(containerViewId)
    f?.let { return@setContentFragment f }
    supportFragmentManager?.beginTransaction()?.add(containerViewId, fragment)?.commit()
    return fragment
}

fun Activity.isLandscape(): Boolean =
        resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

