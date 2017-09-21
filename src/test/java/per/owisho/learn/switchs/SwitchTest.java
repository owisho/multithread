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
	
}

