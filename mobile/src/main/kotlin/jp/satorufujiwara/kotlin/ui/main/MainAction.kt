package jp.satorufujiwara.kotlin.ui.main

import jp.satorufujiwara.kotlin.data.repository.GitHubRepository
import rx.schedulers.Schedulers

class MainAction(val dispatcher: MainDispatcher, val repository: GitHubRepository) {

    fun refreshList(screenId: String) = repository.getRepos("satorufujiwara")
            .subscribeOn(Schedulers.io())
            .subscribe({
                dispatcher.dispatch(screenId, it)
            }, {
                dispatcher.dispatchError("Couldn't get items... ")
            })
}