package unitTesting;
import mainCode.*;

/**
 *  A class to test the functionality of the FightArea class
 */

public class FightAreaTest {

	
    /**
     *  Tests get enemy method 
     */
	
	public void testGetEnemy()
	{
	FightArea fa = new FightArea();
	System.out.println(fa.getEnemy());
	}

    /**
     *  Tests set enemy method 
     */
	
	public void testSetEnemy()
	{
	FightArea fa = new FightArea();
	Enemy e = new Enemy();
	fa.setEnemy(e);
	System.out.println(fa.getEnemy());	
	}
	
	/**
     *  Tests the area info method (when enemy is alive)
	 */
	
	public void testAreaInfo_EnemyAlive()
	{
		FightArea fa = new FightArea();
	    fa.areaInfo();
	    fa.areaInfo();	
	}
	
	/**
     *  Tests the area info method (when enemy is dead)
	 */
	
	public void testAreaInfo_EnemyDead()
	{
		FightArea fa = new FightArea();
	    fa.setEnemy(null);
	    fa.areaInfo();	
	}
	
	/**
     *  Tests the enter condition method (when player has no sword/shield)
	 */
	
	public void testEnterCondition_EmptyInventory()
	{
		FightArea fa = new FightArea();
		PlayerCharacter p = new PlayerCharacter();
		fa.setPlayer(p);
		fa.enterCondition();
	}
	
	/**
     *  Tests the enter condition method (when player has both sword/shield)
	 */
	
	public void testEnterCondition_FullInventory()
	{
		FightArea fa = new FightArea();
		PlayerCharacter p = new PlayerCharacter();
		Shield sh = new Shield();
		Sword sw = new Sword();
		fa.setLoot(sh);
		p.addToInventory(fa);
		fa.setLoot(sw);
		p.addToInventory(fa);
		fa.setPlayer(p);
		fa.enterCondition();
	}
	
	/**
     *  Tests the enter condition method (when player has only a shield)
	 */
	
	public void testEnterCondition_ShieldOnly()
	{
		FightArea fa = new FightArea();
		PlayerCharacter p = new PlayerCharacter();
		Shield sh = new Shield();
		fa.setLoot(sh);
		p.addToInventory(fa);
		fa.setPlayer(p);
		fa.enterCondition();
	}
	
	/**
     *  Tests the enter condition method (when player has only a sword and health is full)
	 */
	
	public void testEnterCondition_PlayerFH()
	{
		FightArea fa = new FightArea();
		PlayerCharacter p = new PlayerCharacter();
		Sword sw = new Sword();
		fa.setLoot(sw);
		p.addToInventory(fa);
		fa.setPlayer(p);
		fa.enterCondition();
	}
	
	/**
     *  Tests the enter condition method (when player has only a sword and health is less than full)
	 */
	
	public void testEnterCondition_PlayerNH()
	{
		FightArea fa = new FightArea();
		PlayerCharacter p = new PlayerCharacter();
		p.setHealth(50);
		Sword sw = new Sword();
		fa.setLoot(sw);
		p.addToInventory(fa);
		fa.setPlayer(p);
		fa.enterCondition();
	}
	
	/**
     *  Tests the enter condition method (when player has only a sword and enemy health is less than full)
	 */
	
	public void testEnterCondition_EnemyNH()
	{
		FightArea fa = new FightArea();
		PlayerCharacter p = new PlayerCharacter();
		Enemy e = new Enemy();
		e.setHealth(50);
		Sword sw = new Sword();
		fa.setLoot(sw);
		p.addToInventory(fa);
		fa.setPlayer(p);
		fa.setEnemy(e);
		fa.enterCondition();
	}
	
}
