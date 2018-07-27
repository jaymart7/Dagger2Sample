package com.mart.dagger2sample.ui.about;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.mart.dagger2sample.R;

import dagger.android.support.DaggerAppCompatActivity;

public class TestActivity extends AppCompatActivity {

    EditText etNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        etNum = findViewById(R.id.et_number);
    }

    public void submit(View view) {
        String strNumber = etNum.getText().toString();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Title")
                .setMessage(strNumber + "php")
                .show();
    }
}
