package jp.satorufujiwara.kotlin.ui.main;

import dagger.Component;
import jp.satorufujiwara.kotlin.AppComponent;
import jp.satorufujiwara.kotlin.DaggerApp;

@MainScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {

    void inject(MainActivity activity);

    void inject(MainFragment fragment);

    static class Initializer {

        private Initializer() {
        }

        public static MainComponent init(MainActivity activity) {
            return DaggerMainComponent.builder()
                    .appComponent(((DaggerApp) activity.getApplication()).appComponent())
                    .mainModule(new MainModule())
                    .build();
        }
    }
}
