package per.owisho.learn.manythread;

public class ManyThreadTest {

	private Object parentObj = new Object();
	
	public static void main(String[] args) {
		
		ManyThreadTest p = new ManyThreadTest();
		ChildThread t = p.new ChildThread();
		t.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程都启动了");
		synchronized (p.parentObj) {
			System.out.println(p.parentObj);
		}
		System.out.println("主线程执行完成");
	}
	
	class ChildThread extends Thread{
		
		@Override
		public void run() {
			synchronized (parentObj) {
				System.out.println(parentObj);
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
}
