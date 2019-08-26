/*
 * Copyright (c) 2019 www.idefav.com Inc. All rights reserved.
 */

package com.idefav.auth.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * the UserDto description.
 *
 * @author wuzishu
 */
@Data
public class UserDto implements Serializable{
    private static final long serialVersionUID = 8142133419621018787L;
    private Long id;

    private String username;

    private String password;

    private String email;

    private Boolean enabled;

    private Boolean accountExpired;

    private Boolean credentialsExpired;

    private Boolean accountLocked;

    private Date createdOn;

    private Date updatedOn;

    private Long version;

    private List<RoleDto> roles;


}
