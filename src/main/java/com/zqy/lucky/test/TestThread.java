package com.zqy.lucky.test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThread extends Thread {

    private static AtomicInteger ai = new AtomicInteger(0);

    private static HashMap<Integer,Integer> map  = new HashMap<>(1);

    @Override
    public void run() {
        while (ai.get()<10000){
            map.put(ai.get(),ai.get());
            ai.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName() + "线程即将结束");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {


        }
    }

}
