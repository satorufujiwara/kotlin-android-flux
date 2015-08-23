package jp.satorufujiwara.kotlin.data.repository

import jp.satorufujiwara.kotlin.data.api.GitHubService
import jp.satorufujiwara.kotlin.data.api.dto.Repo
import rx.Observable
import rx.schedulers.Schedulers

public class GitHubRepository(val gitHubService: GitHubService) {

    public fun getRepos(user: String): Observable<Repo> =
            gitHubService.listRepos(user)
                    .subscribeOn(Schedulers.io())
                    .flatMap { Observable.from(it) }

}
