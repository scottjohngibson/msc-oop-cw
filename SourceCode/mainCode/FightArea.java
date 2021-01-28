package mainCode;

/**
 * A class that represents an area for two living creatures to fight
 */

public class FightArea extends Area implements Unlockable
{
    private Enemy enemy;
    
    public FightArea()
    {
        super();
        enemy = new Enemy();
        setLoot(new Diamond());
        
    }
    
    /**
     *  Returns enemy creature for current area
     *  
     *  @return enemy creature
     */
    
    public Enemy getEnemy()
    {
    	return enemy;
    }
    
    /**
     *  Assigns enemy creature to current area
     *  
     *  @param e	enemy creature
     */
    
    public void setEnemy(Enemy e)
    {
    	enemy = e;
    }
    
    /**
     *  Provides information about player's current area
     */
    
    public void areaInfo()
    {
    if(enemy != null){
    
        if(getAreaProgress() == 0){
        System.out.println("You arrive at a cave. A mighty Troll blocks your path.");
        System.out.println("'If you want into me lair, then you're gonna 'av to kill me first!'");
        incrementAreaProgress();
        }
        
        else System.out.println("You return to the cave - ready to confront the Troll once more.");
    }
    
    else{System.out.println("With the entrance now Troll free - you venture into the cave.");
         System.out.println("You come across a pile of treasures. A top it lies... the Black Diamond of Voldesad!");}
    }
    
    /**
     *  Defines enter conditions for Unlockable areas
     */
    
    public void enterCondition()
    {
    boolean sword = false;
    boolean shield = false;
    boolean condition = false;
    
    if(getPlayer().getInventory().size() > 0){
        for(Item i:getPlayer().getInventory())
            {
                 if(i instanceof Sword) 
                 { 
                  sword = true;
                  break;
                 }
             }
                        
        for(Item i:getPlayer().getInventory())
             {
                 if(i instanceof Shield) 
                 {
                  shield = true;
                  break;
                 }
             }
            }
            
            
    if(sword == false && shield == false)
    {
        getPlayer().setHealth(0);
        System.out.println("Without any protection or weaponry, the Troll makes quick work of you. You are quickly clubbed to a pulp. You are now dead.");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("GAME OVER!");
        System.out.println();
        System.out.println();
        System.out.println();
        
     }
    
    
    if(sword == false && shield == true)
    {
        System.out.println("The Troll picks up a rock and lunges it in your direction - but it is deflected by your shield!");
        System.out.println("If you wish to defeat him however, you will need some sort of weapon.");
    }
    
    if(sword == true && shield == false)
    {
        enemy.reduceHealth(50);
        getPlayer().reduceHealth(50);
        System.out.println("You attack the Troll with your sword, and it looks like you are able to damage him!");    

        if(enemy.getHealth() == 0 && getPlayer().getHealth() > 0){System.out.println("You did it! You killed the Troll!");
                                                                       System.out.println("You may now enter the cave.");
                                                                       enemy = null;
                                                                       condition = true;
                                                                       }
        else if(getPlayer().getHealth() >= 50) System.out.println("You are also badly hurt in the process however. If you wish to defeat the Troll, you will need to protect yourself.");
        else {System.out.println("Yet it was not enough. The Troll takes advantage of your injured state and hurls a boulder in your direction. You are now dead.");
              System.out.println("...");
              System.out.println("...");
              System.out.println("...");
              System.out.println("GAME OVER!");
              System.out.println();
              System.out.println();
              System.out.println();
            }
    }
    
    if(sword == true && shield == true)
    {
      enemy.reduceHealth(100);
      System.out.println("Equipped with both sword and shield, the Troll is no match for your strength. You slay the beast in a matter of seconds.");
      System.out.println("You may now enter the cave.");
      enemy = null;
      condition = true;
    }  
      setConditionsMet(condition);
      
    }

  }



