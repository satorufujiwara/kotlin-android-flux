package jp.satorufujiwara.kotlin

import android.app.Application

import jp.satorufujiwara.kotlin.data.repository.GitHubRepository

public interface BaseAppComponent {

    public fun application(): Application

    public fun gitHubRepository(): GitHubRepository

}
