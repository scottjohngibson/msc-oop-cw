package mainCode;

/**
 * A class representing an empty area i.e. no other living creatures
 */

public class EmptyArea extends Area
{
    
    public EmptyArea()
    {
        super();
        setConditionsMet(true);
    }
    
    /**
     *  Provides information about player's current area
     */
    
    public void areaInfo()
    {
    
    System.out.println("You enter a small area surrounded by trees.");
            
    if(getLoot() != null){System.out.println("You notice a " + getLoot().getItemName() + " in the distance!");}
    else{System.out.println("There is nothing of interest here.");}
    
    }
        
}
