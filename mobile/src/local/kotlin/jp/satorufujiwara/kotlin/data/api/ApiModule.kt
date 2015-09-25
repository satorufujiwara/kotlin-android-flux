package jp.satorufujiwara.kotlin.data.api

import android.content.SharedPreferences

import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppScope
import jp.satorufujiwara.kotlin.data.api.mock.MockGitHubService
import retrofit.Endpoint
import retrofit.Endpoints
import retrofit.MockRestAdapter
import retrofit.RestAdapter
import retrofit.android.AndroidMockValuePersistence

@Module
public class ApiModule {

    @Provides
    @AppScope
    fun provideEndpoint(): Endpoint {
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL)
    }

    @Provides
    @AppScope
    fun provideMockRestAdapter(restAdapter: RestAdapter,
            preferences: SharedPreferences): MockRestAdapter {
        val mockRestAdapter = MockRestAdapter.from(restAdapter)
        AndroidMockValuePersistence.install(mockRestAdapter, preferences)
        return mockRestAdapter
    }

    @Provides
    @AppScope
    fun provideGitHubService(restAdapter: MockRestAdapter): GitHubService {
        return restAdapter.create(GitHubService::class.java, MockGitHubService())
    }

    companion object {

        public val PRODUCTION_API_URL: String = "https://api.github.com"
    }

}
