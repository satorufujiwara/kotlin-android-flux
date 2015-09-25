package jp.satorufujiwara.kotlin

import dagger.Component
import jp.satorufujiwara.kotlin.data.DataModule

@AppScope
@Component(modules = arrayOf(AppModule::class, DataModule::class))
public interface AppComponent : BaseAppComponent {

    public fun inject(app: DaggerApp)

    public object Initializer {

        public fun init(app: DaggerApp): AppComponent {
            return DaggerAppComponent.builder().appModule(AppModule(app)).dataModule(
                    DataModule()).build()
        }
    }

}
