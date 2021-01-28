package unitTesting;
import mainCode.*;

/**
 *  A class to test the functionality of the Game class
 */

public class GameTest {

    /**
     *  Tests get gameboard method 
     */
	
	public void testGetGameboard()
	{
		Game g = new Game();
		System.out.println(g.getGameboard());
	}
	
    /**
     *  Tests get gameboard method 
     */
	
	public void testIndexGameboard()
	{
		Game g = new Game();
		System.out.println(g.indexGameboard(2,2));
	}
	
    /**
     *  Tests get player method 
     */
	
	public void testGetPlayer()
	{
		Game g = new Game();
		System.out.println(g.getPlayer());
	}
	
    /**
     *  Tests set player method 
     */
	
	public void testSetPlayer()
	{
		Game g = new Game();
		PlayerCharacter p = new PlayerCharacter();
		g.setPlayer(p);
		System.out.println(g.getPlayer());
	}
	
    /**
     *  Tests populate gameboard method 
     */
	
	public void testPopulateGameboard()
	{
		Game g = new Game();
		System.out.println(g.indexGameboard(0, 2));
		System.out.println(g.indexGameboard(2, 0));
		System.out.println(g.indexGameboard(3, 4));
		System.out.println(g.indexGameboard(4, 2));
		System.out.println(g.indexGameboard(2, 2).getPlayer());
		System.out.println(g.indexGameboard(3, 3).getLoot());
	}
	
    /**
     *  Tests get area index  method 
     */
	
	public void testGetAreaIndex()
	{
		Game g = new Game();
		Area x = g.indexGameboard(2, 2);
		System.out.println(g.getAreaIndex(x));
	}
	
    /**
     *  Tests get player's location method 
     */
	
	public void testGetPlayerLocation()
	{
		Game g = new Game();
		System.out.println(g.getPlayerLocation());
	}
	
    /**
     *  Tests move West method / move conditions method
     */
	
	public void testMoveWest()
	{
		Game g = new Game();
		// 1) successful move
		g.moveWest();
		// 2) unsuccessful move - locked area
		g.moveWest();
		g.moveSouth();
		g.moveWest();
		// 3) unsuccessful move - boundaries reached
		g.moveWest();		
	}
	
    /**
     *  Tests move North method / move conditions method
     */
	
	public void testMoveNorth()
	{
		Game g = new Game();
		// 1) unsuccessful move - locked area
		g.moveWest();
		g.moveSouth();
		g.moveWest();
		g.moveNorth();
		// 2) successful move
		g.moveEast();
		g.moveNorth();
		// 3) unsuccessful move - boundaries reached
		g.moveNorth();
		g.moveNorth();
		g.moveNorth();		
	}
	
    /**
     *  Tests move South method / move conditions method
     */
	
	public void testMoveSouth()
	{
		Game g = new Game();
		// 1) unsuccessful move - locked area
		g.moveNorth();
		g.moveWest();
		g.moveWest();
		g.moveSouth();
		// 2) successful move
		g.moveEast();
		g.moveSouth();
		// 3) unsuccessful move - boundaries reached
		g.moveSouth();
		g.moveSouth();
		g.moveSouth();		
	}
	
    /**
     *  Tests move East method / move conditions method
     */
	
	public void testMoveEast()
	{
		Game g = new Game();
		// 1) successful move
		g.moveEast();
		// 2) unsuccessful move - locked area
		g.moveSouth();
		g.moveEast();
		// 3) unsuccessful move - boundaries reached
        g.moveSouth();
		g.moveEast();
		g.moveEast();		
	}
	
    /**
     *  Tests add to inventory method 
     */
	
	public void testAddToInventory()
	{
		Game g = new Game();
		g.addToInventory();		
	}
	
    /**
     *  Tests "say magic word" method 
     */
	
	public void testSayMagicWord()
	{
		Game g = new Game();
		PlayerCharacter p = g.getPlayer();
		Area a = g.indexGameboard(2,2);
		Area b = g.indexGameboard(4, 1);
		Area c = g.indexGameboard(3, 3);
		Area d = g.indexGameboard(3, 4);
		g.sayMagicWord();
		System.out.println(d.getConditionsMet());
		a.setPlayer(null);
		c.setPlayer(p);
		g.moveEast();
		b.setPlayer(p);
		d.setPlayer(null);
		g.sayMagicWord();
		System.out.println(c.getConditionsMet());
		
	}
	
    /**
     *  Tests consume potion method 
     */
	
	public void testConsumePotion()
	{
		Game g = new Game();
		PlayerCharacter p = g.getPlayer();
		HealthPotion hp = new HealthPotion();
		g.indexGameboard(2, 2).setLoot(hp);
		g.addToInventory();
		// 1) wont consume with full health
		g.consumePotion();
		// 2 will consume with damaged health
		p.reduceHealth(50);
		g.consumePotion(); 
	}
	
    /**
     *  Tests win condition method 
     */
	
	public void testWinCondition()
	{
		Game g = new Game();
		Diamond d = new Diamond();
		g.indexGameboard(2, 2).setLoot(d);
		g.addToInventory();
	}
	
	
}
