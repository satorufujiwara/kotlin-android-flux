package jp.satorufujiwara.kotlin

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import dagger.Module
import dagger.Provides

@Module
class DebugAppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideApplication(): Application = app

    @Provides
    @AppScope
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()

    @Provides
    @AppScope
    fun provideRefWatcher(application: Application): RefWatcher =
            LeakCanary.install(application)
}
