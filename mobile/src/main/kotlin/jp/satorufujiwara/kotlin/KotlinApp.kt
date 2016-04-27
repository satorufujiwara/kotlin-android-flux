package jp.satorufujiwara.kotlin

import android.app.Application
import android.content.Context
import com.squareup.leakcanary.RefWatcher
import com.squareup.okhttp.OkHttpClient
import jp.satorufujiwara.kotlin.ui.FluxAction
import javax.inject.Inject

class KotlinApp : Application() {

    companion object {
        @JvmStatic fun refWatcher(context: Context): RefWatcher =
                (context.applicationContext as KotlinApp).refWatcher

        @JvmStatic fun appComponent(context: Context): AppComponent =
                (context.applicationContext as KotlinApp).appComponent

    }

    val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this) }
    @Inject lateinit var appLifecycleCallbacks: AppLifecycleCallbacks
    @Inject lateinit var refWatcher: RefWatcher
    @Inject lateinit var okHttpClient: OkHttpClient
    @Inject lateinit var fluxAction: FluxAction


    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        AppGlideModule.registerComponents(this, okHttpClient)
        fluxAction.deleteDispatcherDb()
        appLifecycleCallbacks.onCreate(this)
    }

    override fun onTerminate() {
        appLifecycleCallbacks.onTerminate(this)
        super.onTerminate()
    }

}