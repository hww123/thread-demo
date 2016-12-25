package com.vivi.thread.study.productConcumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	public void produce() throws InterruptedException {
		Random random = new Random();
		while (true) {
			System.out.println(Thread.currentThread().getName() + "produceing.....");
			Thread.sleep(1000);
			Integer value = random.nextInt(100);
			queue.put(value);
			System.out.println("puting value is " + value + " list size is " + queue.size());
			
		}
	}
	
	public void concume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			System.out.println(Thread.currentThread().getName() + "concuming.....");
			Thread.sleep(5000);
			Integer value = queue.take();
			System.out.println("taken value is " + value + " list size is " + queue.size());
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		final App a = new App();
		executorService.submit(new Runnable() {
			public void run() {
				try {
					a.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		executorService.submit(new Runnable() {
			public void run() {
				try {
					a.concume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		executorService.submit(new Runnable() {
			public void run() {
				try {
					a.concume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		executorService.submit(new Runnable() {
			public void run() {
				try {
					a.concume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		executorService.shutdown();
		System.out.println("main finished");
	}

}
