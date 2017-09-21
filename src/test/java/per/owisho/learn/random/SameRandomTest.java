package per.owisho.learn.random;

import java.util.Random;

import org.junit.Test;

import junit.framework.Assert;

public class SameRandomTest {

	private Random r1 = new Random(100);
	
	private Random r2 = new Random(100);
	
	@Test
	public void sameSeedSameResult(){
		Assert.assertEquals(r1.nextInt(), r2.nextInt());
		
	}
	
}
