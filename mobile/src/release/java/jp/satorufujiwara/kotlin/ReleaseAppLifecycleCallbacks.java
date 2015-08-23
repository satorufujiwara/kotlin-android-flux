package jp.satorufujiwara.kotlin;

import com.crashlytics.android.Crashlytics;

import android.app.Application;

import io.fabric.sdk.android.Fabric;
import jp.satorufujiwara.kotlin.util.CrashlyticsTree;
import timber.log.Timber;

public class ReleaseAppLifecycleCallbacks implements AppLifecycleCallbacks{

    @Override
    public void onCreate(Application application) {
        Fabric.with(application, new Crashlytics());
        Timber.plant(new CrashlyticsTree());
    }

    @Override
    public void onTerminate(Application application) {

    }
}
