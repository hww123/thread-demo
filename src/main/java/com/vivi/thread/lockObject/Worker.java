package com.vivi.thread.lockObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	private Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	
	public void stageOne() throws InterruptedException {
		synchronized (lock1) {
			Thread.sleep(1000);
			list1.add(random.nextInt(100));
			System.out.println(Thread.currentThread().getName() + "now list1 size is " + list1.size());
		}
	}
	
	public void stageTwo() throws InterruptedException {
		synchronized (lock2) {
			Thread.sleep(1000);
			list2.add(random.nextInt(100));
			System.out.println(Thread.currentThread().getName() + "now list2 size is " + list1.size());
		}
	}
	
	public void process() throws InterruptedException {
		for (int i = 0; i < 10 ; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start));
		System.out.println("List1 " + list1.size() + "; List2: " + list2.size());
	}
	
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.main();
	}

}
