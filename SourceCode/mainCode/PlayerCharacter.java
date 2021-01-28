package mainCode;
import java.util.*;

/**
 * A class representing the player's character
 */

public class PlayerCharacter extends FightingCreature
{
    private ArrayList<Item> inventory;

    public PlayerCharacter()
    {
        super();
        inventory = new ArrayList<>();
    }
    
    /**
    *  Returns the player's inventory
    *  
    *  @return array-list i.e inventory
    */
    
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    /**
     *  Adds all items in area to player's inventory
     *  
     *  @param a		area to search for items
     */
    
    public void addToInventory(Area a)
    {
    if(a.getLoot() != null)
            {inventory.add(a.getLoot());
             System.out.println("You have added the " + a.getLoot().getItemName() + " to your inventory.");
             a.setLoot(null);}

    else{System.out.println("There is nothing for you to add to your inventory.");}
    
    System.out.println();
    }
    

}

