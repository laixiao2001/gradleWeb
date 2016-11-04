package com.security.dao;

import com.security.domain.SecurityUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by liusven on 2016/11/4.
 */
@Repository
public interface UserDao extends PagingAndSortingRepository<SecurityUser, String>
{
    SecurityUser findBySsoId(String ssoId);
}
