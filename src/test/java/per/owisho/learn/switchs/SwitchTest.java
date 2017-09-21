package per.owisho.learn.switchs;

import org.junit.Test;

public class SwitchTest {

	@Test
	public void test(){
		
		byte age = 10;
		switch (age) {
		case 1:
			System.out.println(1);
			break;

		default:
			break;
		}
		
	}
	
	@Test
	public void test1(){
		Sub<RealSub> sub = new Sub<RealSub>(new RealSub());
		System.out.println(sub.getTClass());;
	}
	
	
}

class RealSub extends SwitchTest{
	
}

class Sub<T extends RealSub>{
	
	public Sub(T t){
		this.t = t;
	}
	
	T t;
	
	public Class getTClass(){
		return t.getClass();
	}
	
}

class Parent<T>{

	
}
