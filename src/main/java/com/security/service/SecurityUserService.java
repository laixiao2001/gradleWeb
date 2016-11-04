package com.security.service;

import com.security.domain.SecurityUser;

/**
 * Created by liusven on 2016/11/4.
 */

public interface SecurityUserService
{

    SecurityUser findById(int id);

    SecurityUser findBySso(String sso);

}
