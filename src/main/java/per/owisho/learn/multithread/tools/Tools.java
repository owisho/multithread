package per.owisho.learn.multithread.tools;

import java.util.Random;

public class Tools {

	//ʹ��ǰ�߳�����time����
	public static void randomPause(int time){
		try {
			Thread.sleep(new Random(50).nextInt(time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
