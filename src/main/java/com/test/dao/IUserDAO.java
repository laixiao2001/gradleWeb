package com.test.dao;

import com.test.common.MyBatisRepository;
import com.test.domain.User;
import java.util.List;

/**
 * Created by liusven on 2016/10/26.
 */
@MyBatisRepository
public interface IUserDAO
{
    List<User> selectUsers();
}
