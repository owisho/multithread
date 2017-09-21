package per.owisho.learn.multithread.base.racecondition;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestIDGenerator {

	private final static RequestIDGenerator INSTANCE = new RequestIDGenerator();
	
	private final static Integer MAX_LIMIT = 999;
	
	private static Integer sequence = -1;
	
	public static RequestIDGenerator getInstance(){
		return INSTANCE;
	}
	
	private Integer nextSequece(){
		if(this.sequence>=999){
			this.sequence = 0;
		}else{
			sequence++;
		}
		return sequence;
	}
	
	public void nextID(){
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		String timestamp = df.format(new Date());
		Integer sequence = nextSequece();
		DecimalFormat numf = new DecimalFormat("000");
		String sequenceStr = numf.format(sequence);
		System.out.printf("%s got sequenceId : %s %n", Thread.currentThread().getName(), "0049"+timestamp+sequenceStr);
	}
	
	
}
