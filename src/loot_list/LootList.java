/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package loot_list;

import java.util.Random;

/**
 * Class Loot List generate and contains Items.
 * This class simulate loot system of game.
 */
public class LootList {
    
    private Item[] items;
    
    private final int minItemsAmount = 2;
    private final int maxItemsAmount = 10;
    
    
    
    /**
     * Constructor.
     * Creating random quality items.
     * @param amount size of Loot List 
     */
    public LootList(int amount) {
        this.createLootList(amount);
    }
    
    /**
     * Constructor.
     * Creating a random amount of random quality items.
     */
    public LootList() {
        int amount = this.generateRandomLootListsSize();
        this.createLootList(amount);
    }
        
    

    /**
     * Interface for items amount.
     * @return 
     */
    public int getSize() {
        return this.items.length;
    }
    
    /**
     * Interface for Item by index
     * @param index
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public Item getItem(int index) throws IndexOutOfBoundsException {
        if (index < this.getSize()) {
            return this.items[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * Interface to set Item in Loot List by index
     * @param item
     * @param index
     * @throws IndexOutOfBoundsException 
     */
    public void setItem(Item item, int index) throws IndexOutOfBoundsException {
        if (index < this.getSize()) {
            this.items[index] = item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    
    
    private int generateRandomLootListsSize() {
        Random random = new Random();
        return random.nextInt(this.maxItemsAmount - this.minItemsAmount) + this.minItemsAmount;
    }
        
    private void createLootList(int amount) {
        this.items = new Item[amount];
        
        for (int i = 0; i < amount; i++) {
            this.items[i] = new Item();
        }
    }
}
