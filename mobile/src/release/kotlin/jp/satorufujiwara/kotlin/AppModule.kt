package jp.satorufujiwara.kotlin

import com.squareup.leakcanary.RefWatcher

import android.app.Application

import dagger.Module
import dagger.Provides

@Module
public class AppModule(private val app: DaggerApp) {

    @Provides
    @AppScope
    fun provideApplication(): Application {
        return app
    }

    @Provides
    public fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks {
        return ReleaseAppLifecycleCallbacks()
    }

    @Provides
    public fun provideRefWatcher(): RefWatcher {
        return RefWatcher.DISABLED
    }

}
