package jp.satorufujiwara.kotlin;

import dagger.Component;
import jp.satorufujiwara.kotlin.data.DebugDataModule;

@AppScope
@Component(
        modules = {
                DebugAppModule.class,
                DebugDataModule.class
        })
public interface AppComponent extends BaseAppComponent {

    void inject(DaggerApp app);

    static class Initializer {

        private Initializer() {
        }

        public static AppComponent init(DaggerApp app) {
            return DaggerAppComponent.builder()
                    .debugAppModule(new DebugAppModule(app))
                    .debugDataModule(new DebugDataModule())
                    .build();
        }
    }

}
