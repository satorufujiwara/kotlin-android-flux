package jp.satorufujiwara.kotlin

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import dagger.Module
import dagger.Provides

@Module
public class DebugAppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideApplication(): Application = app

    @Provides
    @AppScope
    public fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()

    @Provides
    @AppScope
    public fun provideRefWatcher(application: Application): RefWatcher =
            LeakCanary.install(application)
}
