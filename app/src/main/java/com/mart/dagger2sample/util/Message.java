package com.mart.dagger2sample.util;

import android.content.Context;
import android.widget.Toast;

public class Message {

    public static void showToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
