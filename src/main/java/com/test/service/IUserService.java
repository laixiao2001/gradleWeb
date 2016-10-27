package com.test.service;

import com.test.domain.User;
import java.util.List;

/**
 * Created by liusven on 2016/10/26.
 */
public interface IUserService
{
    List<User> findUsers();
}
