package jp.satorufujiwara.kotlin

import com.crashlytics.android.Crashlytics

import android.app.Application

import io.fabric.sdk.android.Fabric
import jp.satorufujiwara.kotlin.util.CrashlyticsTree
import timber.log.Timber

class ReleaseAppLifecycleCallbacks : AppLifecycleCallbacks {

    override fun onCreate(application: Application) {
        Fabric.with(application, Crashlytics())
        Timber.plant(CrashlyticsTree())
    }

    override fun onTerminate(application: Application) {

    }
}
