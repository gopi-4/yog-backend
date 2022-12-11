package com.example.entity;

public class Response {

    private String message;
    private User user;

    public Response(String message, User user){
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
