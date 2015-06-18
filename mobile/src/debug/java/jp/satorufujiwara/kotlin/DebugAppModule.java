package jp.satorufujiwara.kotlin;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import android.app.Application;
import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugAppModule {

    private final DaggerApp app;

    public DebugAppModule(@NonNull final DaggerApp app) {
        this.app = app;
    }

    @Provides
    @AppScope
    Application provideApplication() {
        return app;
    }

    @Provides
    @AppScope
    public AppLifecycleCallbacks provideAppLifecycleCallbacks() {
        return new DebugAppLifecycleCallbacks();
    }

    @Provides
    public RefWatcher provideRefWatcher(Application application) {
        return LeakCanary.install(application);
    }
}
