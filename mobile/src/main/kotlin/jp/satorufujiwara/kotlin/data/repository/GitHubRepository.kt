package jp.satorufujiwara.kotlin.data.repository

import jp.satorufujiwara.kotlin.data.api.GitHubService

class GitHubRepository(val gitHubService: GitHubService) {

    fun getRepos(user: String) = gitHubService.listRepos(user)

}
