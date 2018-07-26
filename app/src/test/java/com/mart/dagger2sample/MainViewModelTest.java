package com.mart.dagger2sample;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;

import com.mart.dagger2sample.data.UserDataSource;
import com.mart.dagger2sample.data.UserRepository;
import com.mart.dagger2sample.model.Results;
import com.mart.dagger2sample.model.User;
import com.mart.dagger2sample.ui.main.MainViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class MainViewModelTest {

    private MainViewModel mainViewModel;

    private Results results;

    @Mock private UserRepository userRepository;

    @Captor private ArgumentCaptor<UserDataSource.LoadUserCallback> loadUserCallback;

    @Mock private Application application;

    @Before
    public void setup(){
        mainViewModel = new MainViewModel(application, userRepository);

        List<User> users = new ArrayList<>();
        users.add(new User("abc@aa"));
        results = new Results();
        results.setUsersList(users);
    }

    @Test
    public void testLoadUsers() {

        mainViewModel.getUserList();

        verify(userRepository).getUserList(eq(10), loadUserCallback.capture());

        loadUserCallback.getValue().onUserListLoaded(results);

    }
}