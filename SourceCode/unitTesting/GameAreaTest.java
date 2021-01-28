package unitTesting;
import mainCode.*;


/**
 *  A class to test the functionality of the GameArea class
 */

public class GameAreaTest {

	/**
	 *  Tests the area info method 
	 */
	
	public void testAreaInfo()
	{
		GameArea ga = new GameArea();
		ga.areaInfo();
		ga.setConditionsMet(true);
		ga.setAreaProgress(1);
		ga.areaInfo();
		ga.areaInfo();
		ga.setLoot(null);
		ga.areaInfo();
	}
	
}
