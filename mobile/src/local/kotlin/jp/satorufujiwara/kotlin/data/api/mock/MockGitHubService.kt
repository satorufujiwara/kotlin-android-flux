package jp.satorufujiwara.kotlin.data.api.mock

import jp.satorufujiwara.kotlin.data.api.GitHubService
import jp.satorufujiwara.kotlin.data.api.dto.Repo
import rx.Observable

class MockGitHubService : GitHubService {

    override fun listRepos(user: String): Observable<List<Repo>> {
        return Observable.just(MockGitHub.MOCK_REPO_LIST)
    }
}
