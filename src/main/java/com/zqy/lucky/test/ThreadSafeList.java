package com.zqy.lucky.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeList {
	public static void main(String[] args) throws InterruptedException {
//		List<String> list = Collections.synchronizedList(new ArrayList<>());
//		List<String> list = new CopyOnWriteArrayList<>();
//		Set<String> list = new CopyOnWriteArraySet<>();
//		Set<String> list = Collections.synchronizedSet(new HashSet<>());
		AtomicInteger a = new AtomicInteger();
		List<String> list = Collections.synchronizedList(new LinkedList<>());
		for (int i = 0; i < 30; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(list);
			},String.valueOf(i)).start();;
		}
		//java.util.ConcurrentModificationException
	}

}
