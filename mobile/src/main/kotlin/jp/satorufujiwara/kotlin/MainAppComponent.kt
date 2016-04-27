package jp.satorufujiwara.kotlin

import android.app.Application
import com.squareup.sqlbrite.BriteDatabase

import jp.satorufujiwara.kotlin.data.repository.GitHubRepository
import jp.satorufujiwara.kotlin.ui.FluxAction

interface MainAppComponent {

    fun application(): Application

    fun gitHubRepository(): GitHubRepository

    fun briteDatabase(): BriteDatabase

    fun fluxAction(): FluxAction

}
