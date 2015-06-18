package jp.satorufujiwara.kotlin.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.OkHttpClient;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import jp.satorufujiwara.kotlin.AppScope;
import jp.satorufujiwara.kotlin.data.api.ApiModule;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

@Module(includes = ApiModule.class)
public class DebugDataModule{

    @Provides
    @AppScope
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences("kotlin", Context.MODE_PRIVATE);
    }

    @Provides
    @AppScope
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @AppScope
    public OkHttpClient provideOkHttpClient(Application app) {
        final OkHttpClient client = new OkHttpClient();
        client.networkInterceptors().add(new StethoInterceptor());
        return client;
    }

    @Provides
    @AppScope
    @Named("Api")
    OkHttpClient provideApiClient(OkHttpClient client) {
        return client.clone();
    }

    @Provides
    @AppScope
    RestAdapter provideRestAdapter(Endpoint endpoint, @Named("Api") OkHttpClient client, Gson gson) {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(client))
                .setEndpoint(endpoint)
                .setConverter(new GsonConverter(gson))
                .build();
    }
}
