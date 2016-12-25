package com.vivi.thread.study.volatiler;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VolatileDemo {
	
	public static void main(String[] args) {
		Processer processer = new Processer();
		processer.start();
		System.out.println("input something to stop threa");
		new Scanner(System.in).nextLine();
		processer.shouDown();
	}
}

class Processer extends Thread {
	private volatile boolean running = true;
	
	@Override
	public void run() {
		while (running) {
			System.out.println("hello!");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shouDown() {
		running = false;
	}
}
