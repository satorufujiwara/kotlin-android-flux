package jp.satorufujiwara.kotlin

import android.app.Application

import jp.satorufujiwara.kotlin.data.repository.GitHubRepository

public interface MainAppComponent {

    public fun application(): Application

    public fun gitHubRepository(): GitHubRepository

}
