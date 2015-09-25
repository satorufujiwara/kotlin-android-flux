package jp.satorufujiwara.kotlin.data.api

import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppScope
import retrofit.Endpoint
import retrofit.Endpoints
import retrofit.RestAdapter

@Module
public class ApiModule {

    @Provides
    @AppScope
    fun provideEndpoint(): Endpoint {
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL)
    }

    @Provides
    @AppScope
    fun provideGitHubService(restAdapter: RestAdapter): GitHubService {
        return restAdapter.create(GitHubService::class.java)
    }

    companion object {

        public val PRODUCTION_API_URL: String = "https://api.github.com"
    }

}
