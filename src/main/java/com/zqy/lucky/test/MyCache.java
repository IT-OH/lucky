package com.zqy.lucky.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {

    private volatile Map<String,String> map = new HashMap<>();

    private ReentrantReadWriteLock lock= new ReentrantReadWriteLock();

    public void put(String k,String v){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": 正在写入： "+ v );
            map.put(k, v);
            System.out.println(Thread.currentThread().getName() + "：写入完成");
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String k){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": 正在读取");
            Object result = map.get(k);
            System.out.println(Thread.currentThread().getName() + ": 读取完成： " + result);
        }finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0;i<5;i++){
            final Integer temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },temp+"号线程").start();
        }

        for (int i = 0;i<5;i++){
            final Integer temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },temp+"号线程").start();
        }
    }

}
