package jp.satorufujiwara.kotlin.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import com.squareup.okhttp.OkHttpClient

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

import javax.inject.Named

import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppScope
import jp.satorufujiwara.kotlin.data.api.ApiModule
import jp.satorufujiwara.kotlin.data.repository.RepositoryModule
import retrofit.Endpoint
import retrofit.RestAdapter
import retrofit.client.OkClient
import retrofit.converter.GsonConverter

@Module(includes = arrayOf(ApiModule::class, RepositoryModule::class))
public class DataModule {

    @Provides
    @AppScope
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("valencia", Context.MODE_PRIVATE)
    }

    @Provides
    @AppScope
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @AppScope
    public fun provideOkHttpClient(app: Application): OkHttpClient {
        val client = OkHttpClient()
        //        File cacheDir = new File(app.getCacheDir(), "http");
        //        Cache cache = new Cache(cacheDir, size);
        //        client.setCache(cache);
        return client
    }

    @Provides
    @AppScope
    @Named("Api")
    fun provideApiClient(client: OkHttpClient): OkHttpClient {
        return client.clone()
    }

    @Provides
    @AppScope
    fun provideRestAdapter(endpoint: Endpoint, @Named("Api") client: OkHttpClient,
            gson: Gson): RestAdapter {
        return RestAdapter.Builder().setClient(OkClient(client)).setEndpoint(endpoint).setConverter(
                GsonConverter(gson)).build()
    }

}
