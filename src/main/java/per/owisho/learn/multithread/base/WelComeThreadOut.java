package per.owisho.learn.multithread.base;

public class WelComeThreadOut extends Thread {
	@Override
	public void run() {
		System.out.printf("out.Welcome I'm %s.%n", Thread.currentThread().getName());
	}
}
