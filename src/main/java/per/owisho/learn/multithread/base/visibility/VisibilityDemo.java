package per.owisho.learn.multithread.base.visibility;

import java.util.Random;

public class VisibilityDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(new Random(50).nextLong());
		
		TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
		Thread thread = new Thread(new TimeConsumingTask());
		thread.start();
		
		//指定的时间内任务没有执行结束的话，就将其取消
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
		
		//
		try {
			Thread.sleep(new Random(50).nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return isDone;
	}
	
	public void cancel(){
		toCancel = true;
		System.out.println(this+" canceled.");
	}
	
}