package unitTesting;
import mainCode.*;

/**
 *  A class to test the functionality of the PlayerCharacter class
 */

public class PlayerCharacterTest {

	public void testGetInventory()
	{
		PlayerCharacter p = new PlayerCharacter();
		System.out.println(p.getInventory());
		
	}
	
	public void testAddToInventory()
	{
		PlayerCharacter p = new PlayerCharacter();
        EmptyArea ea = new EmptyArea();
        Key k = new Key();
        p.addToInventory(ea);
        ea.setLoot(k);
        p.addToInventory(ea);
	}
}
