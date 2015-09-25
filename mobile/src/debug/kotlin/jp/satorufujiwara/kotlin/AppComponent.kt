package jp.satorufujiwara.kotlin

import dagger.Component
import jp.satorufujiwara.kotlin.data.DebugDataModule

@AppScope
@Component(modules = arrayOf(DebugAppModule::class, DebugDataModule::class))
public interface AppComponent : BaseAppComponent {

    public fun inject(app: DaggerApp)

    public object Initializer {
        public fun init(app: DaggerApp): AppComponent {
            return DaggerAppComponent.builder()
                    .debugAppModule(DebugAppModule(app))
                    .debugDataModule(
                            DebugDataModule()).build()
        }
    }
}
