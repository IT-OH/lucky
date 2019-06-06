package com.zqy.lucky.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo1 {

    ReentrantLock lock = new ReentrantLock();

    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+"执行method1方法");
        method2();
    }

    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+"执行method2方法");
    }

    public void method3() {
            lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"执行method3方法");
            method4();
        }finally {
                lock.unlock();
        }
    }

    public void method4(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"执行method3方法");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockDemo1 lock = new LockDemo1();
        new Thread(()->lock.method1(),"AA").start();
        new Thread(()->lock.method3(),"BB").start();
    }

}
