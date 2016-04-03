package jp.satorufujiwara.kotlin.data.repository

import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppScope
import jp.satorufujiwara.kotlin.data.api.GitHubService

@Module
class RepositoryModule {

    @Provides
    @AppScope
    fun provideGitHubRepository(gitHubService: GitHubService): GitHubRepository =
            GitHubRepository(gitHubService)
}
