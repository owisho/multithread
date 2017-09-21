package per.owisho.learn.multithread.base.welcome;

public class WelcomeAppTest {

	public static void main(String[] args) {
		
		Thread welcomeThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("2.Welcome!"+Thread.currentThread().getName());
			}
		});
		
		System.out.println("1.Welcome!"+Thread.currentThread().getName());
		
	}
	
}
