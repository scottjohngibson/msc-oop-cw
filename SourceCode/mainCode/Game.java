package mainCode;
import java.util.*;

/**
 * A class representing the playable game
 */

public class Game
{
    private Area gameboard[][];
    private PlayerCharacter player;
    
    public Game()
    {
        gameboard = new Area[5][5];
        startGame();
    }
    
    /**
     *  Returns the 5*5 gameboard
     *  
     *  @return 2d array 
     */
    
    public Area[][] getGameboard()
    {
        return gameboard;
    }
    
    /**
     *  Returns an area on the gameboard for given coordinates
     *  
     *  @param x	row number
     *  @param y	column number
     *  @return area at given index
     */
    
    public Area indexGameboard(int x, int y)
    {
    return gameboard[x][y];
    }
    
    /**
     * Returns the player's character
     * 
     * @return player character
     */
    
    public PlayerCharacter getPlayer()
    {
    return player;
    }
    
    /**
     *  Assigns the player's character (e.g. to a certain area)
     *  
     *  @param pc		player's character
     */
    
    public void setPlayer(PlayerCharacter pc)
    {
    player = pc;
    }
    
    /**
     *  Starts/resets the game to initial values/locations
     */
    
    public void startGame()
    {
        player = new PlayerCharacter();
        populateGameboard();
        System.out.println("You awaken in the centre of a forest. It is time to continue your search for... the Black Diamond of Voldesad.");
        System.out.println();
    }
    
    /**
     *  Populates the gameboard with areas, items, and the player's character
     */
    
    public void populateGameboard()
    {
      
    for(int row = 0; row < gameboard.length; row++) {
        for(int col = 0; col < gameboard.length; col++) {
            gameboard[row][col] = new EmptyArea();
        }
    }
    
    gameboard[0][2] = new FightArea();
    gameboard[2][0] = new LockedArea();
    gameboard[3][4] = new PuzzleArea();
    gameboard[4][2] = new GameArea();
    gameboard[2][2].setPlayer(player);
    gameboard[3][3].setLoot(new Key());

    }   
    
    /**
     *  Returns index for specified Area on gameboard
     *  
     *  @param a	area to return index for
     *  @return integer array of location
     */
    
    public int[] getAreaIndex(Area a)
    {
    int[] areaIndex = new int[2];
    
    for(int row = 0; row < gameboard.length; row++) {
              for(int col = 0; col < gameboard.length; col++) {
              if(a == indexGameboard(row, col)){areaIndex[0] = row;
                                                areaIndex[1] = col;}
              }
            }
    
    return areaIndex;
    }
     
    /**
     *  Returns index of player's current location
     *  
     *  @return integer array of location
     */
    
    public int[] getPlayerLocation()
    { 
        int[] playerIndex = new int[2];
        
        for(int row = 0; row < gameboard.length; row++) {
              for(int col = 0; col < gameboard.length; col++) {
              if(indexGameboard(row, col).getPlayer() != null){playerIndex[0] = row;
                                                               playerIndex[1] = col;}
              }
            }
        
        return playerIndex;
    }
    
    /**
     *  Evaluates entry conditions that allow player to move position
     *  
     *  @param a 	The area that the player is attempting to move to
     *  @return true if player has met entry requirements
     */
    
    public boolean moveConditions(Area a)
    {  
        int[] newIndex = getAreaIndex(a);
        int[] oldIndex = getPlayerLocation();
        PlayerCharacter player = indexGameboard(getPlayerLocation()[0], getPlayerLocation()[1]).getPlayer();
        boolean condition = false;
        Unlockable unlockableArea = null;
        
        indexGameboard(oldIndex[0], oldIndex[1]).setPlayer(null);
        indexGameboard(newIndex[0],newIndex[1]).setPlayer(player);
        
        if(!(a instanceof EmptyArea)){ 
            unlockableArea = (Unlockable) a;
            if(a instanceof LockedArea){unlockableArea.enterCondition();}
        }
        
     if(a.getConditionsMet() == true)
     {
        condition = true;
     }
     else if(a.getConditionsMet() == false){
        a.areaInfo();
        unlockableArea.enterCondition();
        if(player.getHealth() > 0)System.out.println("You retreat to the previous area.");
        indexGameboard(oldIndex[0],oldIndex[1]).setPlayer(player); 
        indexGameboard(newIndex[0],newIndex[1]).setPlayer(null); 
     }

     if(player.getHealth() == 0){startGame();}
     
     return condition;
    }
    
     /**
     *  Moves the player one square to the West
     */

    public void moveWest()
    {
    int[] newIndex = getPlayerLocation();
    newIndex[1] -= 1;

    
    if(newIndex[1] >= 0){
        
                        System.out.println("You head West.");
                        
                        if(moveConditions(indexGameboard(newIndex[0],newIndex[1])))
                                {
                                 
                                 indexGameboard(newIndex[0],newIndex[1]).areaInfo();
                                }
                                
                        }
    else {System.out.println("You cannot travel any further in this direction.");}
    
    System.out.println();
    }
    

    /**
     *  Moves the player one square to the East
     */
    
    public void moveEast()
    {
    int[] newIndex = getPlayerLocation();
    newIndex[1] += 1;
    
    if(newIndex[1] < gameboard.length){
        
                        System.out.println("You head East.");
                        
                        if(moveConditions(indexGameboard(newIndex[0],newIndex[1])) == true)
                                {
                                 
                                 indexGameboard(newIndex[0],newIndex[1]).areaInfo();}
                                }
                                
                        
    else {System.out.println("You cannot travel any further in this direction.");}
    
    System.out.println();
    }
    
    /**
     *  Moves the player one square to the North
     */
    
    public void moveNorth()
    {
    int[] newIndex = getPlayerLocation();
    newIndex[0] -= 1;
    
    if(newIndex[0] >= 0){
                        
                        System.out.println("You head North.");
        
                        if(moveConditions(indexGameboard(newIndex[0],newIndex[1])) == true)
                                {
                                 
                                 indexGameboard(newIndex[0],newIndex[1]).areaInfo();}       
                        }
    else {System.out.println("You cannot travel any further in this direction.");}    

    System.out.println();
    }
    
    /**
     *  Moves the player one square to the South
     */
    
    public void moveSouth()
    {
    int[] newIndex = getPlayerLocation();
    newIndex[0] += 1;
    
    if(newIndex[0] < gameboard.length){
                        
                        System.out.println("You head South.");                
        
                        if(moveConditions(indexGameboard(newIndex[0],newIndex[1])) == true)
                                {
                                 
                                 indexGameboard(newIndex[0],newIndex[1]).areaInfo();}

                                 }
                                
                        
    else {System.out.println("You cannot travel any further in this direction.");}    

    System.out.println();
    }
    
    /**
     *  Adds any items in area to player's inventory
     */
    
    public void addToInventory()
    {   
    player.addToInventory(indexGameboard(getPlayerLocation()[0],getPlayerLocation()[1]));
    winCondition();
    }
    
    /**
     *  Player says "the magic word" - to complete the PuzzleMaster's challenge
     */
    
    public void sayMagicWord()
    {
        int temp[] = {4,1};
        
        System.out.println("You call out \"the magic word\".");
        System.out.println("...");
        System.out.println("You are unsure if it has done anything.");
        System.out.println();
        
        if(Arrays.equals(getPlayerLocation(), temp) && indexGameboard(3,4).getAreaProgress() > 0){indexGameboard(3,4).setConditionsMet(true);}


    }
    
    /**
     *  Allows player to consume Health Potion if health is not already full
     */
    public void consumePotion()
    {
            for(Item i:player.getInventory())
                            {if(i instanceof HealthPotion) {
                               
                                    if(player.getHealth() < 100) {
                                                                  System.out.println("You drink a Health Potion. You feel much better now.");
                                                                  player.setHealth(100);
                                    }
                                    
                                    else System.out.println("You already feel fine. You don't want to get TOO healthy.");
                            }
                            
                            
                        }
                   
            if(player.getInventory().size() == 0) System.out.println("You don't have any Health Potions on you.");     
            
            System.out.println();
    }
    
    /**
     *  Defines the conditions to win the game
     */
    public void winCondition()
    {
            if(getPlayer().getInventory().size() > 0){
        
        for(Item i:getPlayer().getInventory())
                            {if(i instanceof Diamond) {
                                System.out.println("...");
                                System.out.println("...");
                                System.out.println("...");
                                System.out.println("Congratulations! You have won!");
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                startGame();
                            }
                        }
                    }
                   
            
    }
    
    public static void main(String[] args) {
    	
    	// Running Scenario
    	
    	Game g = new Game();
    	// Get Key
    	g.moveEast();
    	g.moveSouth();
    	g.addToInventory();
    	// Get & Complete Puzzle
    	g.moveEast();
    	g.moveWest();
    	g.moveWest();
    	g.moveSouth();
    	g.sayMagicWord();
    	// Get Health Potion
    	g.moveNorth();
    	g.moveNorth();
    	g.moveWest();
    	g.addToInventory();
    	// Return to Puzzle Master & Get Sword
    	g.moveEast();
    	g.moveEast();
    	g.moveEast();
    	g.moveEast();
    	g.moveSouth();
    	g.addToInventory();
    	// Fight Troll
    	g.moveWest();
    	g.moveWest();
    	g.moveNorth();
    	g.moveNorth();
    	g.moveNorth();
    	g.consumePotion();
    	g.moveNorth();
    	// Find Diamond & Restart Game
    	g.moveNorth();
    	g.addToInventory();
    	
    	
    }
    
}
