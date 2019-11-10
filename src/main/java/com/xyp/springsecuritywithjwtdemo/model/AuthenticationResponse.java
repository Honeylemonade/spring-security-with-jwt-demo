package com.xyp.springsecuritywithjwtdemo.model;

/**
 * AuthenticationResponse:
 *
 * @Author XvYanpeng
 * @Date 2019/11/9 14:46
 */
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
