package mainCode;

/**
 * A superclass representing areas on the gameboard
 */

public abstract class Area
{
    
    private PlayerCharacter player;
    private boolean conditionsMet;
    private Item loot;
    private int areaProgress;
    
    public Area()
    {
    player = null;
    conditionsMet = false;
    loot = null;
    areaProgress = 0;
    }
 
    /**
     *  Returns loot items found in area
     *  
     *  @return loot item
     */
    
    public Item getLoot()
    {
    return loot; 
    }
    
    /**
     *  Assigns loot items to area
     *  
     *  @param l	loot item
     */
    public void setLoot(Item l)
    {
    loot = l;
    }
  
    /**
     *  Returns the current state of progression for an area
     *  
     *  @return progress integer
     */
    
    public int getAreaProgress()
    {
    return areaProgress;
    }
    
    /**
     *  Assigns a state of progression for an area
     *  
     *  @param ap	area progress integer
     */
    
    public void setAreaProgress(int ap)
    {
    areaProgress = ap;
    }
    
    /**
     *  Increments the current state of progression for an area
     */
    
    public void incrementAreaProgress()
    {
    areaProgress++;
    }
    
    /**
     *  Returns the player character for an area
     *  
     *  @return player's character
     */
    
    
    public PlayerCharacter getPlayer()
    {
    return player;
    }
    
    /**
     *  Assigns the player character for an area
     *  
     *  @param p	player's character
     */
    
    public void setPlayer(PlayerCharacter p)
    {
    player = p;
    }
    
    /**
     *  Returns whether entry conditions for Unlockable areas have been met
     *  
     *  @return true if conditions have been met
     */
    
    public boolean getConditionsMet()
    {
    return conditionsMet;
    }
    
    /**
     *  Sets whether entry conditions for Unlockable areas have been met
     *  
     *  @param cm	 boolean - true if condition is met
     */
     
    public void setConditionsMet(boolean cm)
    {
    conditionsMet = cm;
    }
    
    /**
     *  Provides information about player's current area
     */
    
    public abstract void areaInfo();
}
