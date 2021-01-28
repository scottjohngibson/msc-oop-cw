package unitTesting;
import mainCode.*;

/**
 *  A class to test the functionality of the LockedArea class
 */

public class PuzzleAreaTest {

	/**
	 *  Tests the area info method
	 */
	
	public void testAreaInfo()
	{
		PuzzleArea pa = new PuzzleArea();
		pa.areaInfo();
		pa.areaInfo();
		pa.setConditionsMet(true);
		pa.areaInfo();
  		pa.areaInfo();
    }
	
}
