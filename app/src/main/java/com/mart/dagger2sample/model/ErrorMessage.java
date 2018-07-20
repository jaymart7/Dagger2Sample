package com.mart.dagger2sample.model;

import com.mart.dagger2sample.data.UserDataSource.Requests;

public class ErrorMessage {
    private Requests requests;
    private String message;

    public ErrorMessage(Requests requests, String message){
        this.requests = requests;
        this.message = message;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
