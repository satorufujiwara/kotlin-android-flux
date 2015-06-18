package jp.satorufujiwara.kotlin;

import dagger.Component;

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
