package com.zqy.lucky.test;

import java.sql.Time;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Volatile1 {

	public static void main(String[] args) throws InterruptedException {
		Mydata mydata = new Mydata();
//		for (int i = 0; i < 10; i++) {
//			new Thread(() -> {
//				for (int j = 0; j <1000; j++) {
//					mydata.add();
//				}
//			}, "AAA").start();
//		}
		new Thread(() -> {
				mydata.add();
		}, "AAA").start();
		
//		int size = Thread.getAllStackTraces().size();
//		while (Thread.activeCount()>1) {
//			Thread.yield();
//		}
		while (mydata.number.get() == 0) {
			
		}
		// 主线程
		System.out.println(mydata.number);
	}

}

class Mydata {
	
	AtomicInteger number = new AtomicInteger(0);

	public void add() {
		number.getAndSet(10);
	}
}