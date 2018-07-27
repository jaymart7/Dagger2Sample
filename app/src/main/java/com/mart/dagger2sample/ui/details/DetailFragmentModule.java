package com.mart.dagger2sample.ui.details;

import dagger.Module;
import dagger.Provides;

@Module
abstract class DetailFragmentModule {

    @Provides
    static UserAdapter provideAdapterUsers(){
        return new UserAdapter();
    }

}
