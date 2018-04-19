package per.owisho.learn.multithread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	private ReentrantLock lock = new ReentrantLock();
	
	public void method1() {
		try {
			lock.lock();
			System.out.println("method1方法执行了");
			method2();
		} finally {
			lock.unlock();
		}
	}
	
	public void method2() {
		try {
			lock.lock();
			System.out.println("method2方法执行了");
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		//测试场景1两个方法同一个锁嵌套调用，能否正常执行----能
//		ReentrantLockDemo demo = new ReentrantLockDemo();
//		demo.method1();
		//测试场景2两个线程调用同一个对象的同一个方法，能否同时执行（锁是否生效）----锁生效
//		ReentrantLockDemo demo = new ReentrantLockDemo();
//		TestThread t1 = new TestThread(demo);
//		TestThread t2 = new TestThread(demo);
//		t1.start();
//		t2.start();
		
		//测试场景3两个线程调用同一个对象的不同方法，能否同时执行（锁是否生效）
		ReentrantLockDemo demo = new ReentrantLockDemo();
		TestThread t1 = new TestThread(demo);
		TestThread1 t2 = new TestThread1(demo);
		t1.start();
		t2.start();
	}
	
}

class TestThread extends Thread{
	
	private ReentrantLockDemo demo ;
	
	public TestThread(ReentrantLockDemo demo) {
		this.demo = demo ;
	}
	
	@Override
	public void run() {
		demo.method2();
	}
	
}

class TestThread1 extends Thread{
	
	private ReentrantLockDemo demo ;
	
	public TestThread1(ReentrantLockDemo demo) {
		this.demo = demo;
	}
	
	@Override
	public void run() {
		demo.method1();
	}
	
}
