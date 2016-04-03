package jp.satorufujiwara.kotlin

import dagger.Component
import jp.satorufujiwara.kotlin.data.DataModule
import jp.satorufujiwara.kotlin.ui.FluxModule

@AppScope
@Component(modules = arrayOf(AppModule::class, DataModule::class, FluxModule::class))
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
