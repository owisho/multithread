package per.owisho.learn.multithread.base.racecondition;

public class RaceConditionDemo {

	public static void main(String[] args) {
		Integer numberOfThreads = args.length>0?Short.valueOf(args[0]):Runtime.getRuntime().availableProcessors();
		RequestIDGenerator requestIDGenerator = RequestIDGenerator.getInstance();
		Thread[] workerThreads = new Thread[numberOfThreads];
		for(int i = 0;i<numberOfThreads;i++){
			workerThreads[i] = new Thread(new Worker(requestIDGenerator), "worker"+i);
		}
		for(Thread thread : workerThreads){
			thread.start();
		}
		
	}
	
}

class Worker implements Runnable{

	private RequestIDGenerator requestIDGenerator;
	
	public Worker(RequestIDGenerator requestIDGenerator) {
		this.requestIDGenerator = requestIDGenerator;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			requestIDGenerator.nextID();
		}
	}
	
}