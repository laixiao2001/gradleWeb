package com.test.service.impl;

import com.test.dao.IUserDAO;
import com.test.domain.User;
import com.test.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liusven on 2016/10/26.
 */
@Service
public class UserService2 implements IUserService
{
    @Resource
    IUserDAO dao;

    @Override
    public List<User> findUsers()
    {
        return dao.selectUsers();
    }
}
