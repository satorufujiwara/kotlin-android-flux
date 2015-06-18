package jp.satorufujiwara.kotlin.data

import android.app.Activity
import android.content.res.Configuration
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

fun FragmentActivity.setContentFragment(containerViewId: Int, fragment: Fragment?): Fragment? {
    val f: Fragment? = getSupportFragmentManager()?.findFragmentById(containerViewId)
    f?.let { return@setContentFragment f }
    getSupportFragmentManager()?.beginTransaction()?.add(containerViewId, fragment)?.commit()
    return fragment
}

fun Activity.isLandscape(): Boolean {
    return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
}
