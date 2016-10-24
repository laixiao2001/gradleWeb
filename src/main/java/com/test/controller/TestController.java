package com.test.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusven on 2016/10/23.
 */
@RestController
@Scope("prototype")
@RequestMapping("/test")
public class TestController
{

    @RequestMapping("/test")
    public String sayHello()
    {
        return "hello world";
    }
}
