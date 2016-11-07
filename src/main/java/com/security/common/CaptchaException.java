package com.security.common;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by liusven on 2016/11/7.
 */
public class CaptchaException extends AuthenticationException
{
    public CaptchaException(String msg)
    {
        super(msg);
    }
    public CaptchaException(String msg, Throwable t)
    {
        super(msg, t);
    }
}
