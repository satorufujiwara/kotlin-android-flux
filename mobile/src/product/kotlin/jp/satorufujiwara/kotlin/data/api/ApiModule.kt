package jp.satorufujiwara.kotlin.data.api

import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppScope
import retrofit.Endpoint
import retrofit.Endpoints
import retrofit.RestAdapter

@Module
public class ApiModule {

    companion object {
        @JvmStatic val PRODUCTION_API_URL: String = "https://api.github.com"
    }

    @Provides
    @AppScope
    fun provideEndpoint(): Endpoint = Endpoints.newFixedEndpoint(PRODUCTION_API_URL)

    @Provides
    @AppScope
    fun provideGitHubService(restAdapter: RestAdapter): GitHubService =
            restAdapter.create(GitHubService::class.java)

}
