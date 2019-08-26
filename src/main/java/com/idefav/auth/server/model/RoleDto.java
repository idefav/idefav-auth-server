/*
 * Copyright (c) 2019 www.idefav.com Inc. All rights reserved.
 */

package com.idefav.auth.server.model;

import com.idefav.auth.server.model.auto.Permission;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * the RoleDto description.
 *
 * @author wuzishu
 */
@Data
public class RoleDto implements Serializable{
    private static final long serialVersionUID = 4760085274952736788L;
    private Long id;

    private String name;

    private Date createdOn;

    private Date updatedOn;

    private Long version;

    private List<Permission> permissions;
}
