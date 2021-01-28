package mainCode;

/**
 * A class to represent items e.g. keys, shields, potions
 */

public abstract class Item
{
 private String itemName;
 
 /**
 *  Returns the name assigned to an Item object
 *  
 *  @return item name
 */
 
 public String getItemName()
 {
 return itemName;   
 }
 
 
 /**
 *  Assigns a name to an Item object
 *  
 *  @param in	item name
 */
 public void setItemName(String in)
 {
 itemName = in;   
 }
}
