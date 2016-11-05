package com.security.service;

import com.security.domain.SecurityUser;
import com.security.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liusven on 2016/11/4.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{

    @Autowired
    private SecurityUserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException
    {
        SecurityUser user = userService.findBySso(ssoId);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(user.getSsoId(), user.getPassword(),
            user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(SecurityUser user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(UserProfile userProfile : user.getUserProfiles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        return authorities;
    }

}
