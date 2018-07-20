package com.mart.dagger2sample.ui.main.details;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailFragmentProvider {

    @ContributesAndroidInjector(modules = DetailFragmentModule.class)
    abstract DetailsFragment provideDetailFragmentFactory();
}
