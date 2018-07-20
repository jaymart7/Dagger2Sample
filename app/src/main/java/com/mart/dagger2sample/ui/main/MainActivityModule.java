package com.mart.dagger2sample.ui.main;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;

import com.mart.dagger2sample.ViewModelFactory;
import com.mart.dagger2sample.data.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    @Provides
    static MainViewModel provideMainViewModel(Application application, UserRepository userRepository, MainActivity mainActivity){
        return ViewModelProviders.of(mainActivity, new ViewModelFactory(application, userRepository)).get(MainViewModel.class);
    }

}
