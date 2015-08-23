package jp.satorufujiwara.kotlin.data.repository;

import dagger.Module;
import dagger.Provides;
import jp.satorufujiwara.kotlin.AppScope;
import jp.satorufujiwara.kotlin.data.api.GitHubService;

@Module
public class RepositoryModule {

    @Provides
    @AppScope
    GitHubRepository provideGitHubRepository(GitHubService gitHubService) {
        return new GitHubRepository(gitHubService);
    }
}
