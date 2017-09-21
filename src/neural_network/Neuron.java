/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network;

import java.util.Random;

/**
 * Neuron is elementary particle of Neural Network.
 * 
 */

public class Neuron {
    
    private Vector weightsVector;
    
    private final float minValue = 0;
    private final float maxValue = 1f;
    private final float weightsSum = 1f;
    
    
    /**
     * Constructor.
     * Create Neurons with known vector of weights.
     * Weights must be minValue...maxValue.
     * Sum of weights must be 1f.
     * @param weights 
     * @throws neural_network.WrongSumException 
     * @throws neural_network.WrongValueException 
     */
    public Neuron(Vector weights) throws WrongSumException, WrongValueException {
        
        if (!this.valuesInBounds(weights)) {
            throw new WrongValueException("one or more values is out of min/maxValues");
        }
        
        if (!this.checkWeightsSum(weights)) {
            throw new WrongSumException("sum of weights must be 1f");
        }
        
        this.weightsVector = weights;
    }
    
    /**
     * Constructor.
     * Create Neuron with random weights vectors values.
     * @param weightsAmount 
     */
    public Neuron(int weightsAmount) {
        Vector randomVector = this.generateRandomVector(weightsAmount);
        this.weightsVector = this.createUnitVector(randomVector);
    }
    
    
    
    /**
     * Interface for weights Vector
     * @return 
     */
    public Vector getWeightsVector() {
        return this.weightsVector;
    }
    
    /**
     * Interface for state of Neuron.
     * @param inputSignalsVector
     * @return
     * @throws RuntimeException 
     */
    public float calculateState(Vector inputSignalsVector) throws RuntimeException {
        float result = 0;
        
        int size = this.weightsVector.getSize();
        if (size == inputSignalsVector.getSize()) {
            
            for (int i = 0; i < size; i++) {
                result += this.weightsVector.getValue(i) * inputSignalsVector.getValue(i);
            }
            
        } else {
            throw new RuntimeException("different sizes of weightsVector and inputSignalsVector");
        }
        
        //Activation function is linear: f(x) = x, i.e. result = result.
        
        return result;
    }
    
    
    
    /**
     * Checking values of vector.
     * Values must be minValue...maxValue.
     * @param vector
     * @return 
     */
    private boolean valuesInBounds(Vector vector) {
        boolean result  = true;
        
        int size = vector.getSize();
        for (int i = 0; i < size; i++) {
            float value = vector.getValue(i);
            if ((value < this.minValue) || (value > this.maxValue)) {
                result = false;
                break;
            }                
        }
        
        return result;
    }
    
    /**
     * Sum of Weights must be this.weightsSum.
     * @param weights
     * @return 
     */
    private boolean checkWeightsSum(Vector weights) {
        boolean result = false;
        
        float sum = this.calculateWeightsSum(weights);
        if (sum == this.weightsSum) {
            result = true;
        }
        
        return result;
    }
    
    private float calculateWeightsSum(Vector weights) {
        float result = 0;
        
        int size = weights.getSize();
        for (int i = 0; i < size; i++) {
            result += weights.getValue(i);
        }
        
        return result;
    }
    
    /**
     * Creating vector with random values.
     * @param size
     * @return 
     */
    private Vector generateRandomVector(int size) {
        Vector result = new Vector(size);
        
        Random random = new Random();
        for (int i  = 0; i < size; i++) {
            float value = random.nextFloat();
            result.setValue(value, i);
        }
        
        return result;
    }
    
    /**
     * Creating vector with his values Sum is this.weightsSum.
     * @param vector
     * @return 
     */
    private Vector createUnitVector(Vector vector) {
        
        int size = vector.getSize();
        Vector result = new Vector(size);
        
        float sum = this.calculateWeightsSum(vector);
        
        for (int i = 0; i < size; i++) {
            float value = this.weightsSum * vector.getValue(i) / sum;
            result.setValue(value, i);
        }
        
        return result;
    }
    
}