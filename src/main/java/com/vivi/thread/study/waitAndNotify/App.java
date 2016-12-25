package com.vivi.thread.study.waitAndNotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {

	private Queue<Integer> queue = new LinkedList<Integer>();
	private int cabicity;

	public App(int cabicity) {
		this.cabicity = cabicity;
	}

	public void put() throws InterruptedException {
		synchronized (queue) {
			while (queue.size() != 0) {
				System.out.println("队列已满， 请等待..");
				queue.wait();
			}
			TimeUnit.SECONDS.sleep(2);
			int n = new Random().nextInt(100);
			queue.add(n);
			System.out.println("队列已放进去:" + n + " size: " + queue.size() + queue);
			queue.notifyAll();
		}
	}

	public void get() throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == 0) {
				System.out.println("唤醒生成者..");
				queue.wait();
			}
			TimeUnit.SECONDS.sleep(2);
			int value = queue.poll();
			System.out.println("队列已放出： " + value + " size: " + queue.size() + queue);
			queue.notifyAll();
		}
	}

	public static void main(String[] args) {
		final App app = new App(10);
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					while (true) {
						app.get();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					while (true) {
						app.put();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					while (true) {
						app.get();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();

	}
}
