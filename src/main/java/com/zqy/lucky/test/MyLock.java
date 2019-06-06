package com.zqy.lucky.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": come in");
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName() + ": come out");
    }

    public static void main(String[] args) {
//        MyLock myLock = new MyLock();
//        new Thread(()->{
//            myLock.mylock();
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            myLock.myUnLock();
//        },"AAA").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(()->{
//            myLock.mylock();
////            try {
////                Thread.sleep(2000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            System.out.println("123");
//            myLock.myUnLock();
//        },"BBB").start();
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            System.out.println("AAA进来");
            lock.lock();
            try {

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("AAA出去");
                lock.unlock();
            }
        },"AAA").start();

        new Thread(()->{
            System.out.println("BBB进来");
            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("BBB出去");
                lock.unlock();
            }
        },"BBB").start();

    }

}
