package per.owisho.learn.multithread.tools;

import java.util.Random;

public class Tools {

	//使当前线程休眠time毫秒
	public static void randomPause(int time){
		try {
			Thread.sleep(new Random(50).nextInt(time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
