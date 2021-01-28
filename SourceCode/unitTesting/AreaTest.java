package unitTesting;
import mainCode.*;


/**
 *  A class to test the functionality of the abstract Area superclass (via children objects)
 */

public class AreaTest {

	/**
	 *  Tests the get loot method
	 */
	
	public void testGetLoot()
	{
		EmptyArea a = new EmptyArea();
		System.out.println(a.getLoot());	
	}
	
	/**
	 *  Tests the set loot method
	 */
	
	public void testSetLoot()
	{
		EmptyArea a = new EmptyArea();
		Key k = new Key();
		a.setLoot(k);
		System.out.println(a.getLoot());	
	}
	
	/**
	 *  Tests the get area progress method
	 */
	
	public void testGetAreaProgression()
	{
		EmptyArea a = new EmptyArea();
		System.out.println(a.getAreaProgress());	
	}
	
	/**
	 *  Tests the set area progress method
	 */
	
	public void testSetAreaProgress()
	{
		EmptyArea a = new EmptyArea();
		a.setAreaProgress(10);
		System.out.println(a.getAreaProgress());	
	}
	
	/**
	 *  Tests the increment area progress method
	 */
	
	public void testIncrementProgress()
	{
		EmptyArea a = new EmptyArea();
		a.incrementAreaProgress();
		System.out.println(a.getAreaProgress());	
	}
	
	/**
	 *  Tests the get area player method
	 */
	
	public void testGetPlayer()
	{
		EmptyArea a = new EmptyArea();
		System.out.println(a.getPlayer());	
	}
	
	/**
	 *  Tests the set player method
	 */
	
	public void testSetPlayer()
	{
		EmptyArea a = new EmptyArea();
		PlayerCharacter p = new PlayerCharacter();
		a.setPlayer(p);
		System.out.println(a.getPlayer());
	}
	
	/**
	 *  Tests the get conditions met method
	 */
	
	public void testGetConditionsMet()
	{
		EmptyArea a = new EmptyArea();
		System.out.println(a.getConditionsMet());	
	}
	
	/**
	 *  Tests the set player method
	 */
	
	public void testSetConditionsMet()
	{
		EmptyArea a = new EmptyArea();
		a.setConditionsMet(true);
		System.out.println(a.getConditionsMet());
	}
	
	public static void main(String[] args) {   
	}
	
}
