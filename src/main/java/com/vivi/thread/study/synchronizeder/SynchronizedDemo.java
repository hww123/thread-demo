package com.vivi.thread.study.synchronizeder;

import java.util.concurrent.TimeUnit;

public class SynchronizedDemo {

	private int count = 0;

	public synchronized void increment(String threadName) throws InterruptedException {
		count++;
		System.out.println("Thread in process" + threadName + "and count is " + count);
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						increment(Thread.currentThread().getName());
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						increment(Thread.currentThread().getName());
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SynchronizedDemo s = new SynchronizedDemo();
		s.doWork();
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("main...." + i);
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
