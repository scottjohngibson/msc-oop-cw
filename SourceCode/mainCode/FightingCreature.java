package mainCode;

/**
 * A class representing creatures with fighting functionality
 */

public abstract class FightingCreature extends LivingCreature
{
    private int health;
    
    public FightingCreature()
    {
        health = 100;
    }
    
    /**
     *  Returns health of fighting creature
     *  
     *  @return health number 
     */
    
    public int getHealth()
    {
    return health;
    }
    
    /**
     *  Assigns health to fighting creature
     *  
     *  @param h health number 
     */
    
    public void setHealth(int h)
    {
    health = h;
    }
    
    /**
     *  Reduces health of fighting creature
     *  
     *  @param h health number to decrease by
     */
    
    public void reduceHealth(int h)
    {
    health -= h;
    }
    
    /**
     *  Increases health of fighting creature
     *  
     *  @param h health number to increase by
     */
    
    public void addHealth(int h)
    {
    health += h;
    }
    
}
