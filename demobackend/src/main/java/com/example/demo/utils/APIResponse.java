package com.example.demo.utils;

public class APIResponse {

    private String message;

    private boolean success;




    public APIResponse(String message, boolean success) {
        super();
        this.message = message;
        this.success = success;
    }

    public APIResponse() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean issuccess() {
        return success;
    }

    public void setsuccess(boolean success) {
        this.success = success;
    }

}