package com.security.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by liusven on 2016/11/4.
 */
public class EncryptUtil
{
    public static String getBcryptPassword(String originPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(originPassword);
    }
}
