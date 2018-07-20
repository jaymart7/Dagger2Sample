package com.mart.dagger2sample.data.network;


import com.mart.dagger2sample.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api")
    Call<Results> getRandomUsers(@Query("results") int size);
}
