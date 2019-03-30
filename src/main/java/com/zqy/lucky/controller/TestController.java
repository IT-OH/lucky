package com.zqy.lucky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test1(){
        String a = "12321321";
        stringRedisTemplate.opsForValue().set("zqy",a);
        System.out.println(stringRedisTemplate.opsForValue().get("zqy"));
        return "hello world";
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("123456");
        jedis.set("aaaa","aaaaaaaaaa");
        System.out.println(jedis.get("aaaa"));


    }

}
