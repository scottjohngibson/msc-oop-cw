package unitTesting;
import mainCode.*;

/**
 *  A class to test the functionality of the abstract FightingCreature superclass (via children objects)
 */

public class FightingCreatureTest {

	/**
	 *  Tests the get health method
	 */
	
	public void testIncrementProgress()
	{
		Enemy e = new Enemy();
		System.out.println(e.getHealth());	
	}
	
	/**
	 *  Tests the set health method
	 */
	
	public void testSetHealth()
	{
		Enemy e = new Enemy();
		e.setHealth(0);
		System.out.println(e.getHealth());	
	}
	
	/**
	 *  Tests the reduce health method
	 */
	
	public void testReduceHealth()
	{
		Enemy e = new Enemy();
		e.setHealth(100);
		e.reduceHealth(50);
		System.out.println(e.getHealth());	
	}
	
	/**
	 *  Tests the add health method
	 */
	
	public void testAddHealth()
	{
		Enemy e = new Enemy();
		e.setHealth(100);
		e.addHealth(100);
		System.out.println(e.getHealth());	
	}
}
