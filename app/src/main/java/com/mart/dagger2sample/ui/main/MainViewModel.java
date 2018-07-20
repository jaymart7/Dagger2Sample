package com.mart.dagger2sample.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.mart.dagger2sample.data.UserDataSource;
import com.mart.dagger2sample.data.UserRepository;
import com.mart.dagger2sample.model.ErrorMessage;
import com.mart.dagger2sample.model.Results;

import java.util.Objects;

public class MainViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    private MutableLiveData<Results> userList;
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<ErrorMessage> liveErrorMessage = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application, UserRepository userRepository) {
        super(application);
        this.userRepository = userRepository;
        application.getApplicationContext();
    }

    public MutableLiveData<Results> getUserList() {
        if (userList == null){
            userList = new MutableLiveData<>();
            loadUsers();
        }
        return userList;
    }

    public void loadUsers() {
        isLoading.postValue(true);
        userRepository.getUserList(10, new UserDataSource.LoadUserCallback() {
            @Override
            public void onUserListLoaded(Results results) {
                Objects.requireNonNull(userList).postValue(results);
                isLoading.postValue(false);
            }

            @Override
            public void onFailed(ErrorMessage errorMessage) {
                isLoading.postValue(false);
                liveErrorMessage.postValue(errorMessage);
            }

        });
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<ErrorMessage> getLiveErrorMessage() {
        return liveErrorMessage;
    }
}
