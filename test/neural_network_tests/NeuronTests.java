/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import neural_network.Vector;
import neural_network.Neuron;
import neural_network.WrongSumException;
import  neural_network.WrongValueException;

public class NeuronTests {
    
    @Test
    public void test_neuron_0_0_1f() {
        boolean neuronWasCreated = true;
        
        Vector vector = new Vector(new float[] {0, 0, 1f});
        try {
            Neuron neuron = new Neuron(vector);
        } catch (WrongValueException | WrongSumException e) {
            neuronWasCreated = false;
        }
        
        assertTrue(neuronWasCreated);
    }
    
    @Test
    public void test_neuron_0_0_2f_return_RuntimeException_WrongValueException() {
        String exceptionMessage = "";
        
        Vector vector = new Vector(new float[] {0, 0, 2f});
        try {
            Neuron neuron = new Neuron(vector);            
        } catch (WrongSumException | WrongValueException e) {
            exceptionMessage = e.getMessage();
        }
        
        assertEquals(exceptionMessage, "one or more values is out of min/maxValues");
    }
    
    @Test
    public void test_neuron_0_1f_1f_return_RuntimeException_WrongSumException() {
        String exceptionMessage = "";
        
        Vector vector = new Vector(new float[] {0, 1f, 1f});
        try {
            Neuron neuron = new Neuron(vector);
        } catch (WrongSumException | WrongValueException e) {
            exceptionMessage = e.getMessage();
        }
        
        assertEquals(exceptionMessage, "sum of weights must be 1f");
    }
    
    @Test
    public void test_neuron_weightsAmount_3_return_weightsVectorSize_3() {

        Neuron neuron = new Neuron(3);
        Vector weights = neuron.getWeightsVector();
        
        assertEquals(weights.getSize(), 3);
    }
    
    @Test
    public void test_neuron_02f_03f_05f_inputSignals_1f_1f_1f_result_1f() {
        Vector weights = new Vector(new float[] {.2f, .3f, .5f});
        
        try {
            Neuron neuron = new Neuron(weights);
            Vector inputSignals = new Vector(new float[] {1f, 1f, 1f});
            float state = neuron.calculateState(inputSignals);         
            assertEquals(state, 1f, 0);
        
        } catch (WrongValueException | WrongSumException e) {
            System.err.println(e.getMessage());
        }
        
    }
    
    @Test
    public void test_neuron_02f_03f_05f_inputSignals_1f_1f_result_RuntimeException_differentSizes() {
        String exceptionMessage = "";
        
        Vector weights = new Vector(new float[] {.2f, .3f, .5f});
        Neuron neuron;
        
        try {
            neuron = new Neuron(weights);        
            Vector inputSignals = new Vector(new float[] {1f, 1f});
            
            try {
                float state = neuron.calculateState(inputSignals);
            } catch (RuntimeException e) {
                exceptionMessage = e.getMessage();
            }
            
        } catch (WrongValueException | WrongSumException e) {
            System.err.println(e.getMessage());            
        }        
        
        
                
        assertEquals(exceptionMessage, "different sizes of weightsVector and inputSignalsVector");
    }
    
}
