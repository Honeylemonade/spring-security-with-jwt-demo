package com.xyp.springsecuritywithjwtdemo.model;

/**
 * AuthenticationRequest:
 *
 * @Author XvYanpeng
 * @Date 2019/11/9 14:46
 */
public class AuthenticationRequest {
    private String userName;
    private String password;

    public AuthenticationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public AuthenticationRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
