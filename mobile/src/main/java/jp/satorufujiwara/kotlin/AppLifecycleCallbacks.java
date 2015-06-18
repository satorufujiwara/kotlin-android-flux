package jp.satorufujiwara.kotlin;


import android.app.Application;

public interface AppLifecycleCallbacks {

    void onCreate(Application application);

    void onTerminate(Application application);
}
