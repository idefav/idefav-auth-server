/*
 * Copyright (c) 2019 www.idefav.com Inc. All rights reserved.
 */

package com.idefav.auth.server.services;

import com.idefav.auth.server.model.UserDto;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * the CustomUserDetails description.
 *
 * @author wuzishu
 */
@Data
public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = -4274708777012573055L;
    private UserDto user;

    public CustomUserDetails(UserDto user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
            r.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getName())));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.getAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}
