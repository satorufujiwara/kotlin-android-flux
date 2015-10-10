package jp.satorufujiwara.kotlin

import dagger.Component
import jp.satorufujiwara.kotlin.data.DataModule

@AppScope
@Component(modules = arrayOf(AppModule::class, DataModule::class))
public interface AppComponent : MainAppComponent {

    fun inject(app: KotlinApp)

    object Initializer {

        fun init(app: KotlinApp): AppComponent =
                DaggerAppComponent.builder()
                        .appModule(AppModule(app))
                        .dataModule(DataModule())
                        .build()
    }

}
