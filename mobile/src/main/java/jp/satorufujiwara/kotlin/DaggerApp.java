package jp.satorufujiwara.kotlin;

import com.squareup.leakcanary.RefWatcher;
import com.squareup.okhttp.OkHttpClient;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

public class DaggerApp extends Application {

    private AppComponent appComponent;

    @Inject
    AppLifecycleCallbacks appLifecycleCallbacks;

    @Inject
    RefWatcher refWatcher;

    @Inject
    OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
        AppGlideModule.registerComponents(this, okHttpClient);
        appLifecycleCallbacks.onCreate(this);
    }

    @Override
    public void onTerminate() {
        appLifecycleCallbacks.onTerminate(this);
        super.onTerminate();
    }

    public AppComponent appComponent() {
        return appComponent;
    }

    public RefWatcher refWatcher() {
        return refWatcher;
    }

    public static AppComponent appComponent(final Context context) {
        return ((DaggerApp) context.getApplicationContext()).appComponent();
    }

}
