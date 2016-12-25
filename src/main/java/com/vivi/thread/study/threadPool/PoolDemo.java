package com.vivi.thread.study.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 4; i++) {
			executorService.submit(new Processer(i));
		}
		executorService.shutdown();
//		executorService.submit(new Processer(4));
	}

}

class Processer implements Runnable {

	private int name;

	public Processer(int name) {
		this.name = name;
	}

	public void run() {
		System.out.println("process" + name);
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName() + "----hello" + i);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
