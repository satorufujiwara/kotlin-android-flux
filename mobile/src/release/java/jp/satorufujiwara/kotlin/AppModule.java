package jp.satorufujiwara.kotlin;

import com.squareup.leakcanary.RefWatcher;

import android.app.Application;
import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final DaggerApp app;

    public AppModule(@NonNull final DaggerApp app) {
        this.app = app;
    }

    @Provides
    @AppScope
    Application provideApplication() {
        return app;
    }

    @Provides
    public AppLifecycleCallbacks provideAppLifecycleCallbacks() {
        return new ReleaseAppLifecycleCallbacks();
    }

    @Provides
    public RefWatcher provideRefWatcher() {
        return RefWatcher.DISABLED;
    }

}
