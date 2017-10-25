package per.owisho.learn.thread.syn;

/**
 * synchronized 修饰符的使用测试
 * eg:
 * public synchronized void printMsg(){//......方法体}
 * 等价于
 * public void printMsg(){
 * 	  synchronized(this){
 * 		 //......方法体  
 *    }
 * }
 * 因此使用synchronized修饰的方法如果被不同的实例调用就失去了同步的效果
 * 
 * 此类中的main方法对上面的理论进行了论证
 * 
 * @author owisho
 *
 */
public class SynTest {

	public static void main(String[] args) {
		PublicResource r1 = new PublicResource();
		Thread t1 = new Thread(()->{r1.printMsg("线程1");});
		PublicResource r2 = new PublicResource();
		Thread t2 = new Thread(()->{r2.printMsg("线程2");});
		t1.start();
		t2.start();
	}
	
}

class PublicResource{
	
	public synchronized void printMsg(String threadName){
		System.out.println(threadName+"开始调用");
		System.out.println(threadName+"结束调用");
	}
	
}
