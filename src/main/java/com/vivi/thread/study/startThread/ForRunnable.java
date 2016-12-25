package com.vivi.thread.study.startThread;

import java.util.concurrent.TimeUnit;

public class ForRunnable {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new RunnableDemo()).start();
		new Thread(new RunnableDemo()).start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread" + i + "----" + Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(2);
		}
	}

}

class RunnableDemo implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("hello world!" + i + "----" + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
