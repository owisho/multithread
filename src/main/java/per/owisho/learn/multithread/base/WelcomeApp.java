package per.owisho.learn.multithread.base;

public class WelcomeApp {

	public static void main(String[] args) {
		
		Thread welcomeThread = new WelComeThread();
		
		welcomeThread.start();
		
		Thread welcomeThreadOut = new WelComeThreadOut();
		
		welcomeThreadOut.start();
		
		Thread welcomeTask = new Thread(new WelcomeTask());
		
		welcomeTask.start();
		
		System.out.printf("1.Welcome! I'm %s.%n", Thread.currentThread().getName());
				
	}
	
	
}

class WelComeThread extends Thread{
	
	@Override
	public void run() {
//		try {
//			Thread.currentThread().sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.printf("2.Welcome! I'm %s.%n", Thread.currentThread().getName());
	}
	
}

class WelcomeTask implements Runnable{

	@Override
	public void run() {
		System.out.printf("task.Welcome! I'm %s.%n", Thread.currentThread().getName());
	}
	
}