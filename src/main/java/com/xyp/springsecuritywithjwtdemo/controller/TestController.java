package com.xyp.springsecuritywithjwtdemo.controller;

import com.xyp.springsecuritywithjwtdemo.entity.User;
import com.xyp.springsecuritywithjwtdemo.model.AuthenticationRequest;
import com.xyp.springsecuritywithjwtdemo.model.AuthenticationResponse;
import com.xyp.springsecuritywithjwtdemo.service.MyUserDetailService;
import com.xyp.springsecuritywithjwtdemo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController:
 *
 * @Author XvYanpeng
 * @Date 2019/11/2 14:56
 */
@RestController
public class TestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private JWTUtil jwtTokenUtil;

    @GetMapping("/hello")
    public String all() {
        return "<h1>hello</h1>";
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(new User("user","123"), HttpStatus.OK);
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName()
                            , authenticationRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Incorrect userName or password");
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
