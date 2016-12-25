package com.vivi.thread.study.startThread;

import java.util.concurrent.TimeUnit;

public class ForExtend {

	public static void main(String[] args) {
		ThreadDemo t = new ThreadDemo();
		t.run();
	}
}

class ThreadDemo extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello world" + i);
		}
	}
}
