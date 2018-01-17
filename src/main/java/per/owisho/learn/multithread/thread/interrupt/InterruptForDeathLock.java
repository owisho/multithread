package per.owisho.learn.multithread.thread.interrupt;

/**
 * 中断对于死锁问题研究
 * 
 * 死锁的线程无法中断，原因：interrupt方法是一种缓和的打断线程的方法，
 * 他会等待当前线程的任务执行完成后通知线程结束，死锁的线程的无法执行结束，
 * 所以死锁的线程无法通过interrupt方式停止
 * 
 * @author wangyang
 *
 */
public class InterruptForDeathLock {

	public static void main(String[] args) throws Exception{
		final Object lock1 = new Object();
		final Object lock2 = new Object();
		Thread thread1 = new Thread() {
			public void run() {
				deathLock(lock1, lock2);
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				deathLock(lock1, lock2);
			}
		};
		System.out.println("Starting thread...");
		thread1.start();
		thread2.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
		thread1.interrupt();
		thread2.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
	}
	
	static void deathLock(Object lock1,Object lock2) {
		try {
			synchronized (lock1) {
				Thread.sleep(10);
				synchronized (lock2) {
					System.out.println(Thread.currentThread());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
