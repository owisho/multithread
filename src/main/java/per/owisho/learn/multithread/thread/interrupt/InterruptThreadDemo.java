package per.owisho.learn.multithread.thread.interrupt;

/**
 * interrupt方式中断线程学习类
 * @author wangyang
 */
public class InterruptThreadDemo {

	public static void main(String[] args) {
		test4();
	}
	
	/**
	 * 测试中断的线程被再次中断是否会被唤醒（结论会被唤醒）
	 */
	public static void test1() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					long start = System.currentTimeMillis();
					System.out.println("线程还在继续执行");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("此次过程使用时间："+(System.currentTimeMillis()-start));
				}
			}
		});
		t.start();
		while(!t.isInterrupted()) {
			t.interrupt();
		}
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看线程被动中断以后的执行情况(子线程并未结束执行--？待确认是否是自线程是否需要等待子线程自己的任务结束才结束)
	 */
	public static void test2() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					long start = System.currentTimeMillis();
					System.out.println("线程还在继续执行");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						System.out.println("进入线程内异常");
						e.printStackTrace();
					}
					System.out.println(Thread.interrupted());
					System.out.println("此次过程使用时间："+(System.currentTimeMillis()-start));
				}
			}
		});
		t.start();
		try {
			while(!t.isInterrupted()) {
				t.interrupt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("进入异常处理");
			//如果中断异常那么再次进行中断
			t.interrupt();
		}
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试其它线程通过调用Thread的interrupt方法打断线程执行
	 */
	public static void test3() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!Thread.interrupted()) {
					long start = System.currentTimeMillis();
					System.out.println("线程还在继续执行");
					System.out.println(Thread.interrupted());
					System.out.println("此次过程使用时间："+(System.currentTimeMillis()-start));
				}
			}
		});
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(!t.isInterrupted()) {
			System.out.println("主线程打断");
			t.interrupt();
		}
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用interrupt不会打断当前线程正在执行的任务，使用stop会直接打断当前线程正在执行的任务
	 */
	public static void test4() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				long i=0;
				for(;i<10000000000L;i++) {
					
				}
				System.out.println("执行需要时间："+(System.currentTimeMillis()-start));
				System.out.println("执行完i的结果为："+i);
			}
		});
		t.start();
		System.out.println("主线程打断");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t.interrupt();
//		t.stop();
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


