package com.mart.dagger2sample.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
