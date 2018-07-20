package com.mart.dagger2sample.di;

import android.app.Application;
import android.content.Context;

import com.mart.dagger2sample.data.UserRepository;
import com.mart.dagger2sample.data.network.ApiService;

import java.util.concurrent.TimeUnit;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class AppModule {

    @Provides
    static ApiService getApiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build().create(ApiService.class);
    }

    @Provides
    static UserRepository provideUserRepository(ApiService apiService) {
        return new UserRepository(apiService);
    }

    @Binds
    abstract Context provideContext(Application application);
}
