package mainCode;
import java.util.*;

/**
 * A class representing an area containing the Game Master
 */

public class GameArea extends Area implements Unlockable
{
    private GameMaster gameMaster;
    private Random rand;
    
    public GameArea()
    {
    super();
    gameMaster = new GameMaster();
    rand = new Random();
    setLoot(new Shield());
    }
    
    /**
     *  Defines enter conditions for Unlockable areas
     */
    
    public void enterCondition()
    {
    boolean condition;
    int randNum = rand.nextInt(2);

        if(randNum == 0){
            
            System.out.println("You decide to play a dice game with the Dwarf.");
            condition = rollDie();}
        else {
            System.out.println("You decide to play 'Rock, Paper, Scissors' with the Dwarf.");
            condition = rockPaperScissors();
              }
              
    setConditionsMet(condition);

    }

    /**
     *  Simulates a die-rolling game
     *  
     *  @return boolean to indicate whether game has been won
     */
    
        public boolean rollDie()
    {
        int playerNum = rand.nextInt(6), dieNum = rand.nextInt(6);
        boolean conditionMet = false;

        System.out.println("You guess that the die will land on " + playerNum + ".");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("The Dwarf rolls a " + dieNum + ".");
        
            if(playerNum == dieNum)
                          {
                           System.out.println("You can now enter the Dwarf's hut.");
                           conditionMet = true;
                           incrementAreaProgress();
                          }
            else{
                 System.out.println("\"Ye guessed wrong laddy. Better luck next time!\"");
                }
                          
        return conditionMet;
    }
    
    /**
    *  Simulates a game of Rock, Paper, Scissors
    *  
    *   @return boolean to indicate whether game has been won
    */
        
    public boolean rockPaperScissors()
    {
        int playerNum = rand.nextInt(3), dwarfNum = rand.nextInt(3);
        boolean conditionMet = false;
        String[] type = {"Rock", "Paper", "Scissors"};
        
        if(playerNum == dwarfNum){System.out.println("You both chose " + type[playerNum] + ". It's a tie!");}
        else if ((playerNum == 0 && dwarfNum == 2) || (playerNum == 1 && dwarfNum == 0) || (playerNum == 2 && dwarfNum == 1))
        {
            System.out.println("You chose " + type[playerNum] + ". The Dwarf chose " + type[dwarfNum] + ". You win!");
            System.out.println("You can now enter the Dwarf's hut.");
            conditionMet = true;
            incrementAreaProgress();
        }
        else System.out.println("You chose " + type[playerNum] + ". The Dwarf chose " + type[dwarfNum] + ". You lose!");
        
        return conditionMet;
    }
    
    /**
     *  Provides information about player's current area
     */
    
    public void areaInfo()
    {
   
    if(getConditionsMet() == true){    

        if(getAreaProgress() == 1){System.out.println("You enter the Dwarf's tiny home. It lies empty, aside from a small bed.");
                                   System.out.println("Upon closer inspection, you notice that the bed is in fact... a Shield?");
                                   incrementAreaProgress();
        }
        
        else{
                    System.out.println("You arrive upon the wooden hut from before. The Dwarf sits on a nearby rock."); 
         
                    if(getLoot() != null){
                        System.out.println("The lone shield/bed remains the only item in sight.");
                             }
                             else{
                                  System.out.println("You have already taken his only possession.");}   
    }}
    else{
        System.out.println("You arrive upon a wooden hut."); 
        System.out.println("In front of it stands a Dwarf! It appears he wants to play a game with you.");
        System.out.println("\"You there! Dare ye play me at a game of chance? Best me, and I will let into my hut!\"");}
    }
}
