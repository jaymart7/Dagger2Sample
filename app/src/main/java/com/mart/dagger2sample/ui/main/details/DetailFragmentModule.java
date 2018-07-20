package com.mart.dagger2sample.ui.main.details;

import dagger.Module;
import dagger.Provides;

@Module
abstract class DetailFragmentModule {

    @Provides
    static AdapterUsers provideAdapterUsers(){
        return new AdapterUsers();
    }

}
