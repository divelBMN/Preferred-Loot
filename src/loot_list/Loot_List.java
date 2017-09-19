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
public class Loot_List {
    
    private Item[] items;
    
    private final int minItemsAmount = 2;
    private final int maxItemsAmount = 10;
    
    
    
    /**
     * Constructor.
     * Creating random quality items.
     * @param amount size of Loot List 
     */
    public Loot_List(int amount) {
        this.createLootList(amount);
    }
    
    /**
     * Constructor.
     * Creating a random amount of random quality items.
     */
    public Loot_List() {
        int amount = this.generateRandomLootListsSize();
        this.createLootList(amount);
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
