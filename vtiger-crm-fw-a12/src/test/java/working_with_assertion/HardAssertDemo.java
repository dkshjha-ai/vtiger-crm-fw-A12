package working_with_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertDemo {
	@Test
	public void case1() {
		String a = "def";
		String b = "def";
		String c = "xyz";
		
		Object obj1=null;
		Object obj2 =new Object();
		
		boolean status1 =a.equals(b);
		boolean status2 = b.equals(c);
		
		Assert.assertTrue(status1);
		Assert.assertFalse(status2);
				
		Assert.assertEquals(a, b);
		Assert.assertNotEquals(a, c);
		
		Assert.assertNull(obj1);
		Assert.assertNotNull(obj2);
	}

}
