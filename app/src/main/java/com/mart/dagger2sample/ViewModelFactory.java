package com.mart.dagger2sample;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.mart.dagger2sample.data.UserRepository;
import com.mart.dagger2sample.ui.main.MainViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Application application;
    private UserRepository userRepository;

    public ViewModelFactory(Application application, UserRepository userRepository) {
        this.application = application;
        this.userRepository = userRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(application, userRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
