/*
 * Copyright (c) 2019 www.idefav.com Inc. All rights reserved.
 */

package com.idefav.auth.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * the AuthServerApplication description.
 *
 * @author wuzishu
 */
@SpringBootApplication
@MapperScan(basePackages = "com.idefav.auth.server.dao")
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
