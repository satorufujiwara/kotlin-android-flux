package jp.satorufujiwara.kotlin

import dagger.Component
import jp.satorufujiwara.kotlin.data.DataModule

@AppScope
@Component(modules = arrayOf(AppModule::class, DataModule::class))
public interface AppComponent : BaseAppComponent {

    fun inject(app: DaggerApp)

    object Initializer {

        fun init(app: DaggerApp): AppComponent =
                DaggerAppComponent.builder()
                        .appModule(AppModule(app))
                        .dataModule(DataModule())
                        .build()
    }

}
