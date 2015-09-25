package jp.satorufujiwara.kotlin

import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

import android.app.Application

import dagger.Module
import dagger.Provides

@Module
public class DebugAppModule(private val app: DaggerApp) {

    @Provides
    @AppScope
    fun provideApplication(): Application {
        return app
    }

    @Provides
    @AppScope
    public fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks {
        return DebugAppLifecycleCallbacks()
    }

    @Provides
    public fun provideRefWatcher(application: Application): RefWatcher {
        return LeakCanary.install(application)
    }
}
