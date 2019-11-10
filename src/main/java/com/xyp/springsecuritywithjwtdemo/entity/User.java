package com.xyp.springsecuritywithjwtdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User:
 *
 * @Author XvYanpeng
 * @Date 2019/11/3 10:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String password;

}
