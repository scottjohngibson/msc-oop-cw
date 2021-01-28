package unitTesting;
import mainCode.*;

/**
 *  A class to test the functionality of the EmptyArea class
 */

public class EmptyAreaTest {

	/**
     *  Tests the area info method 
	 */
	
	public void testAreaInfo()
	{
		EmptyArea ea = new EmptyArea();
	    Key k = new Key();
	    ea.areaInfo();
	    ea.setLoot(k);
	    ea.areaInfo();
		
	}
}
