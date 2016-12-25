package com.vivi.thread.demo;

public class Demo {
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("test");
			}
		}).start();
	}

}
