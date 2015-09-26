package jp.satorufujiwara.kotlin

import dagger.Component
import jp.satorufujiwara.kotlin.data.DebugDataModule

@AppScope
@Component(modules = arrayOf(DebugAppModule::class, DebugDataModule::class))
public interface AppComponent : BaseAppComponent {

    fun inject(app: DaggerApp)

    object Initializer {
        fun init(app: DaggerApp): AppComponent =
                DaggerAppComponent.builder()
                        .debugAppModule(DebugAppModule(app))
                        .debugDataModule(DebugDataModule())
                        .build()
    }
}
