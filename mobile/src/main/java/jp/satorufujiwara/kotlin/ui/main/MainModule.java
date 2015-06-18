package jp.satorufujiwara.kotlin.ui.main;

import android.app.Application;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import jp.satorufujiwara.kotlin.data.api.GitHubService;
import jp.satorufujiwara.kotlin.data.api.dto.Repo;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class MainModule {

    @Provides
    Observable<List<? extends Repo>> provideGithubObservable(GitHubService gitHubService) {
        return gitHubService.listRepos("octcat")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Provides
    Repo provideRepo(Application application) {
        return new Repo("id", "name");
    }

}
