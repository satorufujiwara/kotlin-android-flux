package jp.satorufujiwara.kotlin;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.timber.StethoTree;
import com.squareup.leakcanary.LeakCanary;

import android.app.Application;

import timber.log.Timber;

public class DebugAppLifecycleCallbacks implements AppLifecycleCallbacks {

    @Override
    public void onCreate(Application application) {
        Timber.plant(new Timber.DebugTree());
        LeakCanary.install(application);
        Stetho.initialize(
                Stetho.newInitializerBuilder(application)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(application))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(application))
                        .build());
        Timber.plant(new StethoTree());
    }

    @Override
    public void onTerminate(Application application) {

    }
}
