package com.zqy.lucky.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsumer_Traditiondemo {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while (number!=0)
                condition.await();
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number==0)
                condition.await();
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProdConsumer_Traditiondemo prodConsumer_traditiondemo = new ProdConsumer_Traditiondemo();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.increment();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.decrement();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.increment();
            }
        },"CC").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.decrement();
            }
        },"DD").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.increment();
            }
        },"EE").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.decrement();
            }
        },"FF").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.increment();
            }
        },"TT").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                prodConsumer_traditiondemo.decrement();
            }
        },"YY").start();

    }

}
