package com.security.service.impl;

import com.security.dao.UserDao;
import com.security.domain.SecurityUser;
import com.security.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liusven on 2016/11/4.
 */
@Service("securityUserService")
@Transactional
public class SecurityUserServiceImpl implements SecurityUserService
{
    @Autowired
    private UserDao dao;

    public SecurityUser findById(int id) {
        return dao.findOne(String.valueOf(id));
    }

    public SecurityUser findBySso(String sso) {
        return dao.findBySsoId(sso);
    }

}