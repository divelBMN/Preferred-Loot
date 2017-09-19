/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package loot_list_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import loot_list.Item;
import neural_network.Vector;

public class ItemTests {
    
    @Test
    public void test_Item_quality_BAD_result_bad() {
        Item item = new Item(Item.Quality.BAD);
        assertEquals(item.qualityTitle(), "bad");
    }
    
    @Test
    public void test_Item_quality_COMMON_result_common() {
        Item item = new Item(Item.Quality.COMMON);
        assertEquals(item.qualityTitle(), "common");
    }
    
    @Test
    public void test_Item_quality_GOOD_result_good() {
        Item item = new Item(Item.Quality.GOOD);
        assertEquals(item.qualityTitle(), "good");
    }
    
    @Test
    public void test_Item_quality_RARE_result_rare() {
        Item item = new Item(Item.Quality.RARE);
        assertEquals(item.qualityTitle(), "rare");
    }
    
    @Test
    public void test_Item_quality_EPIC_result_epic() {
        Item item = new Item(Item.Quality.EPIC);
        assertEquals(item.qualityTitle(), "epic");
    }
    
    @Test
    public void test_Item_quality_SET_result_set() {
        Item item = new Item(Item.Quality.SET);
        assertEquals(item.qualityTitle(), "set");
    }
    
    @Test
    public void test_Item_quality_BAD_result_signalsVector_1f_0_0_0_0_0() {
        Item item = new Item(Item.Quality.BAD);
        Vector signalsVector = item.signalsVector();
        assertEquals(signalsVector.value(0), 1f, 0);
        assertEquals(signalsVector.value(1), 0, 0);
        assertEquals(signalsVector.value(2), 0, 0);
        assertEquals(signalsVector.value(3), 0, 0);
        assertEquals(signalsVector.value(4), 0, 0);
        assertEquals(signalsVector.value(5), 0, 0);
    }
    
    @Test
    public void test_Item_quality_COMMON_result_signalsVector_0_1f_0_0_0_0() {
        Item item = new Item(Item.Quality.COMMON);
        Vector signalsVector = item.signalsVector();
        assertEquals(signalsVector.value(0), 0, 0);
        assertEquals(signalsVector.value(1), 1f, 0);
        assertEquals(signalsVector.value(2), 0, 0);
        assertEquals(signalsVector.value(3), 0, 0);
        assertEquals(signalsVector.value(4), 0, 0);
        assertEquals(signalsVector.value(5), 0, 0);
    }
    
    @Test
    public void test_Item_quality_GOOD_result_signalsVector_0_0_1f_0_0_0() {
        Item item = new Item(Item.Quality.GOOD);
        Vector signalsVector = item.signalsVector();
        assertEquals(signalsVector.value(0), 0, 0);
        assertEquals(signalsVector.value(1), 0, 0);
        assertEquals(signalsVector.value(2), 1f, 0);
        assertEquals(signalsVector.value(3), 0, 0);
        assertEquals(signalsVector.value(4), 0, 0);
        assertEquals(signalsVector.value(5), 0, 0);
    }
    
    @Test
    public void test_Item_quality_RARE_result_signalsVector_0_0_0_1f_0_0() {
        Item item = new Item(Item.Quality.RARE);
        Vector signalsVector = item.signalsVector();
        assertEquals(signalsVector.value(0), 0, 0);
        assertEquals(signalsVector.value(1), 0, 0);
        assertEquals(signalsVector.value(2), 0, 0);
        assertEquals(signalsVector.value(3), 1f, 0);
        assertEquals(signalsVector.value(4), 0, 0);
        assertEquals(signalsVector.value(5), 0, 0);
    }
    
    @Test
    public void test_Item_quality_EPIC_result_signalsVector_0_0_0_0_1f_0() {
        Item item = new Item(Item.Quality.EPIC);
        Vector signalsVector = item.signalsVector();
        assertEquals(signalsVector.value(0), 0, 0);
        assertEquals(signalsVector.value(1), 0, 0);
        assertEquals(signalsVector.value(2), 0, 0);
        assertEquals(signalsVector.value(3), 0, 0);
        assertEquals(signalsVector.value(4), 1f, 0);
        assertEquals(signalsVector.value(5), 0, 0);
    }
    
    @Test
    public void test_Item_quality_SET_result_signalsVector_0_0_0_0_0_1f() {
        Item item = new Item(Item.Quality.SET);
        Vector signalsVector = item.signalsVector();
        assertEquals(signalsVector.value(0), 0, 0);
        assertEquals(signalsVector.value(1), 0, 0);
        assertEquals(signalsVector.value(2), 0, 0);
        assertEquals(signalsVector.value(3), 0, 0);
        assertEquals(signalsVector.value(4), 0, 0);
        assertEquals(signalsVector.value(5), 1f, 0);
    }
    
}
