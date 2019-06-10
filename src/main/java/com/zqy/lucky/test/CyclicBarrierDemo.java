package com.zqy.lucky.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main (String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7);
        for (int i = 1; i <=7; i++) {
            System.out.println("\t 收集到底"+ i +"颗龙珠");
            final int tempint = i;
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        System.out.println("召唤神龙");
    }

}
