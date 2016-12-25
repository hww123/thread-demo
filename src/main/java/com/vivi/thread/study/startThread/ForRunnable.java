package com.vivi.thread.study.startThread;

import java.util.concurrent.TimeUnit;

public class ForRunnable {
	
	public static void main(String[] args) {
		
	}

}

class RunnableDemo implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("hello world!");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
