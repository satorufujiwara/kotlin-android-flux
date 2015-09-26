package jp.satorufujiwara.kotlin.data

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.facebook.stetho.okhttp.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.okhttp.OkHttpClient
import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppScope
import jp.satorufujiwara.kotlin.data.api.ApiModule
import jp.satorufujiwara.kotlin.data.repository.RepositoryModule
import retrofit.Endpoint
import retrofit.RestAdapter
import retrofit.client.OkClient
import retrofit.converter.GsonConverter
import javax.inject.Named

@Module(includes = arrayOf(ApiModule::class, RepositoryModule::class))
public class DebugDataModule {

    @Provides
    @AppScope
    fun provideSharedPreferences(app: Application): SharedPreferences =
            app.getSharedPreferences("kotlin", Context.MODE_PRIVATE)

    @Provides
    @AppScope
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @AppScope
    public fun provideOkHttpClient(app: Application): OkHttpClient {
        val client = OkHttpClient()
        client.networkInterceptors().add(StethoInterceptor())
        return client
    }

    @Provides
    @AppScope
    @Named("Api")
    fun provideApiClient(client: OkHttpClient): OkHttpClient = client.clone()

    @Provides
    @AppScope
    fun provideRestAdapter(endpoint: Endpoint, @Named("Api") client: OkHttpClient,
            gson: Gson): RestAdapter =
            RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setClient(OkClient(client))
                    .setEndpoint(endpoint)
                    .setConverter(GsonConverter(gson))
                    .build()
}
