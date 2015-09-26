package jp.satorufujiwara.kotlin

import android.app.Application
import com.squareup.leakcanary.RefWatcher
import dagger.Module
import dagger.Provides

@Module
public class AppModule(private val app: DaggerApp) {

    @Provides
    @AppScope
    fun provideApplication(): Application = app

    @Provides
    @AppScope
    public fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = ReleaseAppLifecycleCallbacks()

    @Provides
    @AppScope
    public fun provideRefWatcher(): RefWatcher = RefWatcher.DISABLED

}
