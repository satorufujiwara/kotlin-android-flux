package jp.satorufujiwara.kotlin.data.api;

import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import jp.satorufujiwara.kotlin.AppScope;
import jp.satorufujiwara.kotlin.data.api.mock.MockGitHubService;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.android.AndroidMockValuePersistence;

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
    MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter, SharedPreferences preferences) {
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        AndroidMockValuePersistence.install(mockRestAdapter, preferences);
        return mockRestAdapter;
    }

    @Provides
    @AppScope
    GitHubService provideGitHubService(MockRestAdapter restAdapter) {
        return restAdapter.create(GitHubService.class, new MockGitHubService());
    }

}
