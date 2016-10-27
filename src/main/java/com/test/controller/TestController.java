package com.test.controller;

import com.test.jpa.User;
import com.test.jpa.user.UserService;
import com.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liusven on 2016/10/23.
 */
@RestController
@Scope("prototype")
@RequestMapping("/test")
public class TestController
{
    @Autowired
    private UserService userService;

    @Autowired
    private IUserService userService2;

    @RequestMapping("/test")
    public String sayHello()
    {
        return "hello world";
    }


    @RequestMapping("/addUser")
    public User addUser(User user)
    {
        return userService.saveUser(user);
    }

    @RequestMapping("/findAllUsers")
    public List<com.test.domain.User> findUsers()
    {
        return userService2.findUsers();
    }
}
