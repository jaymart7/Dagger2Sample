package com.mart.dagger2sample.di;

import com.mart.dagger2sample.ui.main.MainActivity;
import com.mart.dagger2sample.ui.main.MainActivityModule;
import com.mart.dagger2sample.ui.main.details.DetailFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, DetailFragmentProvider.class} )
    abstract MainActivity binMainActivity();
}
