/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package loot_list_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import loot_list.LootList;
import loot_list.Item;

public class LootListTests {
    
    @Test
    public void test_LootList_2_items_size_return_2() {
        int itemsAmount = 2;
        LootList loot = new LootList(itemsAmount);
        assertEquals(loot.getSize(), itemsAmount);
    }
    
    @Test
    public void test_LootList_3_get_item_byIndex_2_return_item() {
        int itemsAmount = 3;
        LootList loot = new LootList(itemsAmount);
        
        boolean thrown = false;
        try {
            Item item = loot.getItem(2);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        
        assertFalse(thrown);
    }
    
    @Test
    public void test_LootList_3_get_item_byIndex_3_return_exception() {
        int itemsAmount = 3;
        LootList loot = new LootList(itemsAmount);
        
        boolean thrown = false;
        try {
            Item item = loot.getItem(3);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        
        assertTrue(thrown);
    }
    
    @Test
    public void test_LootList_3_set_item_byIndex_2_return_common() {
        int itemsAmount = 3;
        LootList loot = new LootList(itemsAmount);
        
        boolean thrown = false;
        try {
            Item item = new Item(Item.Quality.COMMON);
            loot.setItem(item, 2);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        
        String qualityTitle = loot.getItem(2).getQualityTitle();
        assertEquals(qualityTitle, "common");
    }
    
    @Test
    public void test_LootList_3_set_item_byIndex_3_return_exception() {
        int itemsAmount = 3;
        LootList loot = new LootList(itemsAmount);
        
        boolean thrown = false;
        try {
            Item item = new Item(Item.Quality.COMMON);
            loot.setItem(item, 3);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        
        assertTrue(thrown);
    }
    
}