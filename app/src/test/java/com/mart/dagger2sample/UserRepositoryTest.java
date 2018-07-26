package com.mart.dagger2sample;

import com.google.gson.Gson;
import com.mart.dagger2sample.data.UserDataSource;
import com.mart.dagger2sample.data.UserRepository;
import com.mart.dagger2sample.di.AppModule;
import com.mart.dagger2sample.model.ErrorMessage;
import com.mart.dagger2sample.model.Results;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private UserRepository userRepository;
    private Results myResults;

    @Before
    public void setup(){
        userRepository = new UserRepository(AppModule.getApiService());
    }

    @Test
    public void testGetUserList() throws InterruptedException {
        userRepository.getUserList(10, new UserDataSource.LoadUserCallback() {

            @Override
            public void onUserListLoaded(Results results) {
                myResults = results;
                countDownLatch.countDown();
            }

            @Override
            public void onFailed(ErrorMessage errorMessage) {
                countDownLatch.countDown();
                fail(errorMessage.getMessage());
            }
        });

        countDownLatch.await();
        System.out.println(new Gson().toJson(myResults));
        assertNotNull(myResults);
    }

}
