/*
 * Copyright (c) 2019 www.idefav.com Inc. All rights reserved.
 */

package com.idefav.auth.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * the RedisConfig description.
 *
 * @author wuzishu
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class RedisConfig {
    @Value("${spring.redis.host:localhost}")
    String HostName;
    @Value("${spring.redis.port:6379}")
    int Port;

    //    @Bean
//    public LettuceConnectionFactory connectionFactory() {
//        LettuceConnectionFactory lettuceConnectionFactory=new LettuceConnectionFactory();
//
//        return lettuceConnectionFactory;
//    }

}
