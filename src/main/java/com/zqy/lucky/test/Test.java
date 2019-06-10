package com.zqy.lucky.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

public class Test {

    private final JedisPool jedisPool;

    public Test(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public String lockWithTimeout(String lockName,long acquireTimeout,long timeout){
        Jedis conn = null;
        String retIdentifier = null;
        conn = jedisPool.getResource();
        String identifier = UUID.randomUUID().toString();
        String lockKey = "lock:"+lockName;
        int lockExpire = (int) (timeout/1000);
        long end = System.currentTimeMillis()+acquireTimeout;
        while (System.currentTimeMillis()<end){
        }
        return retIdentifier;
    }


    public static void main(String[] args) {

    }






}
