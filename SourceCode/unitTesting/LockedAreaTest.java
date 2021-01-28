package unitTesting;
import mainCode.*;

/**
 *  A class to test the functionality of the LockedArea class
 */

public class LockedAreaTest {

	/**
	 *  Tests the enter condition method
	 */
	
	public void testEnterCondition()
	{
		LockedArea la = new LockedArea();
		PlayerCharacter p = new PlayerCharacter();
		Key k = new Key();
		la.setPlayer(p);
		la.enterCondition();
		System.out.println(la.getConditionsMet());
		p.getInventory().add(k);
		la.enterCondition();
		System.out.println(la.getConditionsMet());
	}
	
	/**
	 *  Tests the area info method
	 */
	
	public void testAreaInfo()
	{
		LockedArea la = new LockedArea();
        la.areaInfo();
        la.setConditionsMet(true);
		la.areaInfo();
		la.setLoot(null);
		la.areaInfo();
	}
}
