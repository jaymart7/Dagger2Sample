package com.mart.dagger2sample.util;

import org.json.JSONObject;

import okhttp3.ResponseBody;

public class Parse {

    public static String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("error");
        } catch (Exception e) {
            return "Server Error";
        }
    }
}
