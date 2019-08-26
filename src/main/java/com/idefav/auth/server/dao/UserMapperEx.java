/*
 * Copyright (c) 2019 www.idefav.com Inc. All rights reserved.
 */

package com.idefav.auth.server.dao;

import com.idefav.auth.server.model.UserDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapperEx {

    @Select("SELECT\n" +
            "  a.id,\n" +
            "  a.username,\n" +
            "  a.password,\n" +
            "  a.email,\n" +
            "  a.enabled,\n" +
            "  a.account_expired,\n" +
            "  a.credentials_expired,\n" +
            "  a.account_locked,\n" +
            "  a.created_on,\n" +
            "  a.updated_on,\n" +
            "  a.version,\n" +
            "  c.id role_id,\n" +
            "  c.name role_name,\n" +
            "  c.created_on role_created_on,\n" +
            "  c.updated_on role_updated_on,\n" +
            "  c.version role_version,\n" +
            "  e.id permission_id,\n" +
            "  e.name permission_name,\n" +
            "  e.version permission_version,\n" +
            "  e.updated_on permission_updated_on,\n" +
            "  e.created_on permission_created_on\n" +
            "FROM user a\n" +
            "  LEFT JOIN role_user b ON a.id = b.user_id\n" +
            "  LEFT JOIN role c ON b.role_id=c.id\n" +
            "  LEFT JOIN permission_role d ON b.role_id=d.role_id\n" +
            "  LEFT JOIN permission e ON d.permission_id = e.id\n" +
            "WHERE email = #{email}")
    @ResultMap("BaseMapResultEx")
    UserDto findByEmail(@Param("email") String email);

    @Select("SELECT\n" +
            "  a.id,\n" +
            "  a.username,\n" +
            "  a.password,\n" +
            "  a.email,\n" +
            "  a.enabled,\n" +
            "  a.account_expired,\n" +
            "  a.credentials_expired,\n" +
            "  a.account_locked,\n" +
            "  a.created_on,\n" +
            "  a.updated_on,\n" +
            "  a.version,\n" +
            "  c.id role_id,\n" +
            "  c.name role_name,\n" +
            "  c.created_on role_created_on,\n" +
            "  c.updated_on role_updated_on,\n" +
            "  c.version role_version,\n" +
            "  e.id permission_id,\n" +
            "  e.name permission_name,\n" +
            "  e.version permission_version,\n" +
            "  e.updated_on permission_updated_on,\n" +
            "  e.created_on permission_created_on\n" +
            "FROM user a\n" +
            "  LEFT JOIN role_user b ON a.id = b.user_id\n" +
            "  LEFT JOIN role c ON b.role_id=c.id\n" +
            "  LEFT JOIN permission_role d ON b.role_id=d.role_id\n" +
            "  LEFT JOIN permission e ON d.permission_id = e.id\n" +
            "WHERE username = #{username}")
    @ResultMap("BaseMapResultEx")
    UserDto findByUsername(@Param("username") String username);
}