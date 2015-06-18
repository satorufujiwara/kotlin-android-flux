package jp.satorufujiwara.kotlin;

import android.app.Application;

import jp.satorufujiwara.kotlin.data.api.GitHubService;

public interface BaseAppComponent {

    Application application();

    GitHubService githubService();

}
