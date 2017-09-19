/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network;

/**
 * Class Vector used for work with input/output signals and weights of neurons.
 */
public class Vector {
    
    private float [] values;
    
    
    
    /**
     * Constructor.
     * Make Vector with known values.
     * @param values 
     */
    public Vector(float [] values) {
        this.values = values;
    }    
    
    /**
     * Constructor.
     * Make vector with values is zero.
     * @param size 
     */
    public Vector(int size) {
        this.values = this.zeroVector(size);
    }
    
    
    
    /**
     * Interface for amount of values
     * @return 
     */
    public int size() {
        return this.values.length;
    }
    
    /**
     * Interface for getting value by index.
     * @param index
     * @return 
     */
    public float value(int index) throws IndexOutOfBoundsException {
        if (index < this.values.length) {
            return this.values[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * Interface for setting value by index.
     * @param value
     * @param index
     * @throws IndexOutOfBoundsException 
     */
    public void setValue(float value, int index) throws IndexOutOfBoundsException {
        if (index < this.values.length) {
            this.values[index] = value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
            
    
    /**
     * Creating array of float with values is zero
     * @param size of array
     * @return 
     */
    private float [] zeroVector(int size) {
        float[] result = new float[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = 0;
        }
        
        return result;
    }
}
