package jp.satorufujiwara.kotlin.util

import com.crashlytics.android.Crashlytics

import android.util.Log

import timber.log.Timber

public class CrashlyticsTree : Timber.Tree() {

    override fun log(priority: Int, tag: String, message: String, t: Throwable?) {
        if (priority != Log.ERROR) {
            return
        }
        Crashlytics.getInstance().core.log(priority, tag, message)
        if (t != null) {
            Crashlytics.getInstance().core.logException(t)
        }
    }

}
