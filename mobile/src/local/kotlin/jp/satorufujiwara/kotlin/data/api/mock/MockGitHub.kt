package jp.satorufujiwara.kotlin.data.api.mock

import jp.satorufujiwara.kotlin.data.api.dto.Repo

object MockGitHub {

    val MOCK_REPO_LIST: List<Repo> = arrayListOf(
            Repo(id = "1000", name = "mock-repo0"),
            Repo(id = "1001", name = "mock-repo1"),
            Repo(id = "1002", name = "mock-repo2"),
            Repo(id = "1003", name = "mock-repo3"),
            Repo(id = "1004", name = "mock-repo4")
    )
}
