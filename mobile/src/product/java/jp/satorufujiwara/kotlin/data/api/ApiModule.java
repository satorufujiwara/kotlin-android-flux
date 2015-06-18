package jp.satorufujiwara.kotlin.data.api;

import dagger.Module;
import dagger.Provides;
import jp.satorufujiwara.kotlin.AppScope;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;

@Module
public class ApiModule {

    public static final String PRODUCTION_API_URL = "https://api.github.com";

    @Provides
    @AppScope
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL);
    }

    @Provides
    @AppScope
    GitHubService provideGitHubService(RestAdapter restAdapter) {
        return restAdapter.create(GitHubService.class);
    }

}
