package unitTesting;
import mainCode.*;

/**
 * A class to test the functionality of the abstract Item superclass (via children objects)
 */

public class ItemTest {

	/**
	 *  Tests the get item name method
	 */
	
	public void testGetItemName()
	{
		Key k = new Key();
		System.out.println(k.getItemName());	
	}
	
	/**
	 *  Tests the set item name method
	 */
	
	public void testSetItemName()
	{
		Key k = new Key();
		k.setItemName("Test");
		System.out.println(k.getItemName());	
	}
	
}
