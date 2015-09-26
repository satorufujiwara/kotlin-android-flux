package jp.satorufujiwara.kotlin

import android.app.Application
import com.facebook.stetho.Stetho
import com.facebook.stetho.timber.StethoTree
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber

public class DebugAppLifecycleCallbacks : AppLifecycleCallbacks {

    override fun onCreate(application: Application) {
        Timber.plant(Timber.DebugTree())
        LeakCanary.install(application)
        Stetho.initialize(Stetho.newInitializerBuilder(application)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(application))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(application))
                .build())
        Timber.plant(StethoTree())
    }

    override fun onTerminate(application: Application) {

    }
}
