package com.mart.dagger2sample.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mart.dagger2sample.R;
import com.mart.dagger2sample.ui.about.TestActivity;

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

    public void test(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }
}
