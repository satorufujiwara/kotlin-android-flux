package jp.co.cyberagent.valencia;

import dagger.Component;
import jp.satorufujiwara.kotlin.AppModule;
import jp.satorufujiwara.kotlin.AppScope;
import jp.satorufujiwara.kotlin.BaseAppComponent;
import jp.satorufujiwara.kotlin.DaggerApp;
import jp.satorufujiwara.kotlin.DataModule;

@AppScope
@Component(
        modules = {
                AppModule.class,
                DataModule.class
        })
public interface AppComponent extends BaseAppComponent {

    void inject(DaggerApp app);

    static class Initializer {

        private Initializer() {
        }

        public static AppComponent init(DaggerApp app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .dataModule(new DataModule())
                    .build();
        }
    }

}
