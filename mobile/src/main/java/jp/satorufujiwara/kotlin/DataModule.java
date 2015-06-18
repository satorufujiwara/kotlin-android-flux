package jp.satorufujiwara.kotlin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.squareup.okhttp.OkHttpClient;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import jp.satorufujiwara.kotlin.data.api.ApiModule;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

@Module(
        includes = {
                ApiModule.class
        })
public class DataModule {

    @Provides
    @AppScope
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences("valencia", Context.MODE_PRIVATE);
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
//        File cacheDir = new File(app.getCacheDir(), "http");
//        Cache cache = new Cache(cacheDir, size);
//        client.setCache(cache);
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
                .setClient(new OkClient(client))
                .setEndpoint(endpoint)
                .setConverter(new GsonConverter(gson))
                .build();
    }

}
