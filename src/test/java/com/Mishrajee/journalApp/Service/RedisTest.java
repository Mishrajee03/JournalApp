package com.Mishrajee.journalApp.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    @Disabled
    void testSendMail(){
        redisTemplate.opsForValue().set("email","hariom@123");
        Object name = redisTemplate.opsForValue().get("name");
        int a=1;
    }
}
