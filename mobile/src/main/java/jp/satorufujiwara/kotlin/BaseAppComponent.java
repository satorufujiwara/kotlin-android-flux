package jp.satorufujiwara.kotlin;

import android.app.Application;

import jp.satorufujiwara.kotlin.data.repository.GitHubRepository;

public interface BaseAppComponent {

    Application application();

    GitHubRepository gitHubRepository();

}
