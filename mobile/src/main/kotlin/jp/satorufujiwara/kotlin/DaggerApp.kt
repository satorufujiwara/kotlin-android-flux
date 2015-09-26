package jp.satorufujiwara.kotlin

import android.app.Application
import com.squareup.leakcanary.RefWatcher
import com.squareup.okhttp.OkHttpClient
import javax.inject.Inject

public open class DaggerApp : Application() {

    val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this) }
    @Inject lateinit val appLifecycleCallbacks: AppLifecycleCallbacks
    @Inject lateinit val refWatcher: RefWatcher
    @Inject lateinit val okHttpClient: OkHttpClient

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        AppGlideModule.registerComponents(this, okHttpClient)
        appLifecycleCallbacks.onCreate(this)
    }

    override fun onTerminate() {
        appLifecycleCallbacks.onTerminate(this)
        super.onTerminate()
    }

    public fun refWatcher(): RefWatcher {
        return refWatcher
    }

}
