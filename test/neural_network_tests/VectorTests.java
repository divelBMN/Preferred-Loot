/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import neural_network.Vector;

public class VectorTests {
    
    @Test
    public void test_vector_0_0_0_size_return_3() {
        int size = 3;
        Vector vector = new Vector(size);
        assertEquals(vector.size(), size);
    }
    
    @Test
    public void test_vector_0_1f_0_value_by_index_1_return_1f() {
        Vector vector = new Vector(new float[] {0, 1f, 0});
        assertEquals(vector.value(1), 1f, 0);
    }
    
    @Test
    public void test_vector_0_1f_0_value_by_index_3_return_IndexOutOfBoundsException() {
        Vector vector = new Vector(new float[] {0, 1f, 0});
        
        boolean thrown = false;
        try {
            float value = vector.value(3);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        
        assertTrue(thrown);
    }
    
    @Test
    public void test_vector_0_0_0_0_setValue_1f_index_1_return_0_1f_0_0() {
        int vectorSize = 4;
        Vector vector = new Vector(vectorSize);
        vector.setValue(1f, 1);
        
        assertEquals(vector.value(0), 0, 0);
        assertEquals(vector.value(1), 1f, 0);
        assertEquals(vector.value(2), 0, 0);
        assertEquals(vector.value(3), 0, 0);
    }
    
    @Test
    public void test_vector_0_0_0_setValue_by_index_3_return_IndexOutOfBoundsException() {
        int vectorSize = 3;
        Vector vector = new Vector(vectorSize);
        
        boolean thrown = false;
        try {
            float value = vector.value(3);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        
        assertTrue(thrown);
    }
    
}