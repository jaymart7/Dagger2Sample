package com.mart.dagger2sample.data;

import com.mart.dagger2sample.model.ErrorMessage;
import com.mart.dagger2sample.model.Results;
import com.mart.dagger2sample.model.User;

public interface UserDataSource {

    interface LoadUserCallback {

        default void onUserListLoaded(Results results) {}
        default void onUserLoaded(User user) {}

        void onFailed(ErrorMessage errorMessage);
    }

    void getUserList(int count, LoadUserCallback loadUserCallback);

    enum Requests{
        GET_USER_LIST,
        GET_USER,
        ADD_USER,
        UPDATE_USER
    }
}
