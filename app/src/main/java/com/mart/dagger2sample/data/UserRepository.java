package com.mart.dagger2sample.data;

import android.support.annotation.NonNull;

import com.mart.dagger2sample.data.network.ApiService;
import com.mart.dagger2sample.model.ErrorMessage;
import com.mart.dagger2sample.model.Results;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mart.dagger2sample.util.Parse.getErrorMessage;

public class UserRepository implements UserDataSource {

    private ApiService apiService;

    public UserRepository(ApiService apiService){
        this.apiService = apiService;
    }

    @Override
    public void getUserList(int count, LoadUserCallback loadUserCallback) {
        apiService.getRandomUsers(count)
                .enqueue(new Callback<Results>() {
                    @Override
                    public void onResponse(@NonNull Call<Results> call, @NonNull Response<Results> response) {
                        if (response.errorBody() == null) {
                            loadUserCallback.onUserListLoaded(response.body());
                        }
                        else {
                            loadUserCallback.onFailed(new ErrorMessage(Requests.GET_USER_LIST, getErrorMessage(response.errorBody())));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Results> call, @NonNull Throwable t) {
                        loadUserCallback.onFailed(new ErrorMessage(Requests.GET_USER_LIST, t.getMessage()));
                    }
                });
    }
}
