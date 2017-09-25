package per.owisho.learn.multithread.base.visibility;

import java.util.Random;

import per.owisho.learn.multithread.tools.Tools;

public class VisibilityDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(new Random(50).nextLong());
		
		TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
//		Thread thread = new Thread(new TimeConsumingTask()); ԭ����뱾����Ϊ�����Լ��޸ĺ�Ĵ���
		Thread thread = new Thread(timeConsumingTask);
		thread.start();
		
		//ָ����ʱ��������û��ִ�н����Ļ����ͽ���ȡ��
		Thread.sleep(10000);
		timeConsumingTask.cancel();
	}
	
}

class TimeConsumingTask implements Runnable{

	private boolean toCancel = false;
	
	@Override
	public void run() {
		while(!toCancel){
			if(doExecute()){
				break;
			}
		}
	}
	
	private boolean doExecute(){
		boolean isDone = false;
		System.out.println("executing ...");
		
		Tools.randomPause(1000);
		
		return isDone;
	}
	
	public void cancel(){
		toCancel = true;
		System.out.println(this+" canceled.");
	}
	
}