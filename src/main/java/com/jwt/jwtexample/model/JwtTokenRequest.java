package com.jwt.jwtexample.model;

public class JwtTokenRequest {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
}
