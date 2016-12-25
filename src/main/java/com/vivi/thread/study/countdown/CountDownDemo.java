package com.vivi.thread.study.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownDemo {

	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CountDownLatch c = new CountDownLatch(3);
		System.out.println("begin..");
		for (int i = 0; i < 3; i++) {
			executorService.submit(new Procsser(c));
			TimeUnit.SECONDS.sleep(1);
		}
		c.await();
		System.out.println("finisheds");
	}
}

class Procsser implements Runnable {
	
	private CountDownLatch c;
	
	public Procsser(CountDownLatch c) {
		this.c = c;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + ", hello");
		c.countDown();
	}
	
}
