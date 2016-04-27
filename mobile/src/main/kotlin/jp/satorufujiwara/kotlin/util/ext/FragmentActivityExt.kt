package jp.satorufujiwara.kotlin.util.ext

import android.content.Context
import android.support.annotation.IntDef
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.widget.Toast

fun FragmentActivity.setContentFragment(containerViewId: Int, fragment: Fragment?): Fragment? {
    val f: Fragment? = supportFragmentManager?.findFragmentById(containerViewId)
    f?.let { return@setContentFragment f }
    supportFragmentManager?.beginTransaction()?.add(containerViewId, fragment)?.commit()
    return fragment
}

@IntDef(Toast.LENGTH_SHORT.toLong(), Toast.LENGTH_LONG.toLong())
annotation class Duration

fun Context.showToast(text: String, @Duration length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}
