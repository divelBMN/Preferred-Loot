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
        assertEquals(item.getQualityTitle(), "bad");
    }
    
    @Test
    public void test_Item_quality_COMMON_result_common() {
        Item item = new Item(Item.Quality.COMMON);
        assertEquals(item.getQualityTitle(), "common");
    }
    
    @Test
    public void test_Item_quality_GOOD_result_good() {
        Item item = new Item(Item.Quality.GOOD);
        assertEquals(item.getQualityTitle(), "good");
    }
    
    @Test
    public void test_Item_quality_RARE_result_rare() {
        Item item = new Item(Item.Quality.RARE);
        assertEquals(item.getQualityTitle(), "rare");
    }
    
    @Test
    public void test_Item_quality_EPIC_result_epic() {
        Item item = new Item(Item.Quality.EPIC);
        assertEquals(item.getQualityTitle(), "epic");
    }
    
    @Test
    public void test_Item_quality_SET_result_set() {
        Item item = new Item(Item.Quality.SET);
        assertEquals(item.getQualityTitle(), "set");
    }
    
    @Test
    public void test_Item_quality_BAD_result_signalsVector_1f_0_0_0_0_0_0() {
        Item item = new Item(Item.Quality.BAD);
        Vector signalsVector = item.getSignalsVector();
        assertEquals(signalsVector.getValue(0), 1f, 0);
        assertEquals(signalsVector.getValue(1), 0, 0);
        assertEquals(signalsVector.getValue(2), 0, 0);
        assertEquals(signalsVector.getValue(3), 0, 0);
        assertEquals(signalsVector.getValue(4), 0, 0);
        assertEquals(signalsVector.getValue(5), 0, 0);
        assertEquals(signalsVector.getValue(6), 0, 0);
    }
    
    @Test
    public void test_Item_quality_COMMON_result_signalsVector_0_1f_0_0_0_0_0() {
        Item item = new Item(Item.Quality.COMMON);
        Vector signalsVector = item.getSignalsVector();
        assertEquals(signalsVector.getValue(0), 0, 0);
        assertEquals(signalsVector.getValue(1), 1f, 0);
        assertEquals(signalsVector.getValue(2), 0, 0);
        assertEquals(signalsVector.getValue(3), 0, 0);
        assertEquals(signalsVector.getValue(4), 0, 0);
        assertEquals(signalsVector.getValue(5), 0, 0);
        assertEquals(signalsVector.getValue(6), 0, 0);
    }
    
    @Test
    public void test_Item_quality_GOOD_result_signalsVector_0_0_1f_0_0_0_0() {
        Item item = new Item(Item.Quality.GOOD);
        Vector signalsVector = item.getSignalsVector();
        assertEquals(signalsVector.getValue(0), 0, 0);
        assertEquals(signalsVector.getValue(1), 0, 0);
        assertEquals(signalsVector.getValue(2), 1f, 0);
        assertEquals(signalsVector.getValue(3), 0, 0);
        assertEquals(signalsVector.getValue(4), 0, 0);
        assertEquals(signalsVector.getValue(5), 0, 0);
        assertEquals(signalsVector.getValue(6), 0, 0);
    }
    
    @Test
    public void test_Item_quality_RARE_result_signalsVector_0_0_0_1f_0_0_0() {
        Item item = new Item(Item.Quality.RARE);
        Vector signalsVector = item.getSignalsVector();
        assertEquals(signalsVector.getValue(0), 0, 0);
        assertEquals(signalsVector.getValue(1), 0, 0);
        assertEquals(signalsVector.getValue(2), 0, 0);
        assertEquals(signalsVector.getValue(3), 1f, 0);
        assertEquals(signalsVector.getValue(4), 0, 0);
        assertEquals(signalsVector.getValue(5), 0, 0);
        assertEquals(signalsVector.getValue(6), 0, 0);
    }
    
    @Test
    public void test_Item_quality_EPIC_result_signalsVector_0_0_0_0_1f_0_0() {
        Item item = new Item(Item.Quality.EPIC);
        Vector signalsVector = item.getSignalsVector();
        assertEquals(signalsVector.getValue(0), 0, 0);
        assertEquals(signalsVector.getValue(1), 0, 0);
        assertEquals(signalsVector.getValue(2), 0, 0);
        assertEquals(signalsVector.getValue(3), 0, 0);
        assertEquals(signalsVector.getValue(4), 1f, 0);
        assertEquals(signalsVector.getValue(5), 0, 0);
        assertEquals(signalsVector.getValue(6), 0, 0);
    }
    
    @Test
    public void test_Item_quality_SET_result_signalsVector_0_0_0_0_0_1f_0() {
        Item item = new Item(Item.Quality.SET);
        Vector signalsVector = item.getSignalsVector();
        assertEquals(signalsVector.getValue(0), 0, 0);
        assertEquals(signalsVector.getValue(1), 0, 0);
        assertEquals(signalsVector.getValue(2), 0, 0);
        assertEquals(signalsVector.getValue(3), 0, 0);
        assertEquals(signalsVector.getValue(4), 0, 0);
        assertEquals(signalsVector.getValue(5), 1f, 0);
        assertEquals(signalsVector.getValue(6), 0, 0);
    }
    
    @Test
    public void test_Item_quality_BAD_GradationIndex_result_0() {
        Item item = new Item(Item.Quality.BAD);
        assertEquals(item.getQualityGradationIndex(), 0);
    }
    
    @Test
    public void test_Item_quality_COMMON_GradationIndex_result_1() {
        Item item = new Item(Item.Quality.COMMON);
        assertEquals(item.getQualityGradationIndex(), 1);
    }
    
    @Test
    public void test_Item_quality_GOOD_GradationIndex_result_2() {
        Item item = new Item(Item.Quality.GOOD);
        assertEquals(item.getQualityGradationIndex(), 2);
    }
    
    @Test
    public void test_Item_quality_RARE_GradationIndex_result_3() {
        Item item = new Item(Item.Quality.RARE);
        assertEquals(item.getQualityGradationIndex(), 3);
    }
    
    @Test
    public void test_Item_quality_EPIC_GradationIndex_result_4() {
        Item item = new Item(Item.Quality.EPIC);
        assertEquals(item.getQualityGradationIndex(), 4);
    }
    
    @Test
    public void test_Item_quality_SET_GradationIndex_result_5() {
        Item item = new Item(Item.Quality.SET);
        assertEquals(item.getQualityGradationIndex(), 5);
    }
    
}
