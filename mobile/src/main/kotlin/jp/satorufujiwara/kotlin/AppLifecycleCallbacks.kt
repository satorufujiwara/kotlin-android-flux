package jp.satorufujiwara.kotlin


import android.app.Application

public interface AppLifecycleCallbacks {

    public fun onCreate(application: Application)

    public fun onTerminate(application: Application)
}
