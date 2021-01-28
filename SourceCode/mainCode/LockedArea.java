package mainCode;

/**
 * A class representing an area that can be unlocked with the key object
 */

public class LockedArea extends Area implements Unlockable
{
    
    public LockedArea()
    {
    super();
    setLoot(new HealthPotion());
    }
    
    /**
    *  Defines enter conditions for Unlockable areas
    */
    
    public void enterCondition()
    {
        boolean condition = false;

        if(getPlayer().getInventory().size() > 0){
        
        for(Item i:getPlayer().getInventory())
                            {if(i instanceof Key) {
                                condition = true;
                                break;
                            }
                        }
                    }
                            
        setConditionsMet(condition); 
    }
    
    /**
     *  Provides information about player's current area
     */
    
    public void areaInfo()
    {
    
       
    System.out.println("You stand before a small cottage."); 
        
    if(getConditionsMet() == true){    
        
        System.out.println("You unlock the cottage door with your key!");
            
        if(getLoot() != null){System.out.println("You head inside and fi-Wait. What's this? Why, there's a Health Potion! You should steal it.");}
        else{System.out.println("Oh, wait - you have already robbed this place.");}   
    }
    else{
        System.out.println("It looks like it is locked.");
    }
    }
}
