package per.owisho.learn.multithread.base.visibility;

import java.util.Random;

import per.owisho.learn.multithread.tools.Tools;

public class VisibilityDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(new Random(50).nextLong());
		
		TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
//		Thread thread = new Thread(new TimeConsumingTask()); 原书代码本人认为有误，自己修改后的代码
		Thread thread = new Thread(timeConsumingTask);
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
		
		Tools.randomPause(1000);
		
		return isDone;
	}
	
	public void cancel(){
		toCancel = true;
		System.out.println(this+" canceled.");
	}
	
}