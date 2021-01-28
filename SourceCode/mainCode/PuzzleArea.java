package mainCode;

/**
 * A class representing an area containing a puzzle master
 */

public class PuzzleArea extends Area implements Unlockable
{
    private PuzzleMaster puzzleMaster;
    
    public PuzzleArea()
    {
        super();
        puzzleMaster = new PuzzleMaster();
        setLoot(new Sword());
    }
    
    /**
     *  Provides information about player's current area
     */
    
    public void areaInfo()
    {
    if(getConditionsMet() == true){    

        if(getAreaProgress() <= 1){System.out.println("You return to the large stone building. The Elf cheers as you arrive.");
                                   System.out.println("\"You did it! You have completed my puzzle! You may come inside now!\"");
                                   System.out.println("You follow the Elf into his home. He shows you to his collection of swords... and gives you permission to take one!");
                                   setAreaProgress(2);
        }
        
        else{
                    System.out.println("You return to the large stone building - your new friend, the Elf, beckons you inside once more."); 
         
                    if(getLoot() != null){
                        System.out.println("\"You still haven't picked your Sword, traveler!\"");
                             }
                    
    }}
    else{
        if(getAreaProgress() == 0){System.out.println("You stumble upon a large building made of stone."); 
                                   System.out.println("Out front stands an Elf! It appears he wishes to speak with you.");
                                   System.out.println("\"Traveler! I see you wish to enter my home. I will grant you access, but only if you can complete my puzzle.\"");
                                   System.out.println("\"Head South-West - as far as you can, then a step once more to the Dwarven man. Once there - speak 'the magic word', return here and you'll find a Sword.\"");
                                   incrementAreaProgress();
                                  }
        else {
              System.out.println("You arrive upon the large stone building from before. \"What are you doing? Go and finish my puzzle!\"");
              System.out.println("Remember, it goes - \"Head South-West - as far as you can, then a step once more to the Dwarven man. Once there - speak 'the magic word', return here and you'll find a Sword.\"");
             }
    }}
    
    /**
    *  Defines enter conditions for Unlockable areas
    */
    
    public void enterCondition()
    {
    }
    
}
