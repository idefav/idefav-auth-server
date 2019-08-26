/*
 * Copyright (c) 2019 www.idefav.com Inc. All rights reserved.
 */

package com.idefav.auth.server.services;

import com.idefav.auth.server.dao.UserMapperEx;
import com.idefav.auth.server.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * the CustomUserDetailsService description.
 *
 * @author wuzishu
 */
@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapperEx userMapperEx;

    @Override
    public UserDetails loadUserByUsername(String input) {
        UserDto user;

        if (input.contains("@"))
            user = userMapperEx.findByEmail(input);
        else
            user = userMapperEx.findByUsername(input);

        if (user == null)
            throw new BadCredentialsException("Bad credentials");

        CustomUserDetails customUserDetails=new CustomUserDetails(user);

        new AccountStatusUserDetailsChecker().check(customUserDetails);

        return customUserDetails;
    }
}
