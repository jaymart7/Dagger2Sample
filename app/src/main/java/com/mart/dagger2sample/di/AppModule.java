package com.mart.dagger2sample.di;

import android.app.Application;
import android.content.Context;

import com.mart.dagger2sample.data.UserRepository;
import com.mart.dagger2sample.data.network.ApiClient;
import com.mart.dagger2sample.data.network.ApiService;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Provides
    static ApiService getApiService() {
        return ApiClient.getClient();
    }

    @Provides
    static UserRepository provideUserRepository(ApiService apiService) {
        return new UserRepository(apiService);
    }

    @Binds
    abstract Context provideContext(Application application);
}
