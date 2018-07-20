package com.mart.dagger2sample.ui.main;

import android.os.Bundle;

import com.mart.dagger2sample.R;
import com.mart.dagger2sample.data.UserDataSource;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView (R.layout.activity_main);

    }
}
