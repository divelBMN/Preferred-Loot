/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network;

import loot_list.*;

public class Teacher {
    
    private final Neuron neuron;
    private final LootList loot;
    private final int[] selectedIndices;
    
    private float correctionsThreshold;
    
    
    
    /**
     * Constructor.
     * @param neuron
     * @param loot
     * @param selectedIndices
     * @param unselectedGradationsAmount 
     */
    public Teacher(Neuron neuron, LootList loot, int [] selectedIndices, int unselectedGradationsAmount) {
        this.neuron = neuron;
        this.loot = loot;
        this.selectedIndices = selectedIndices;
        
        float potentialNeededItemsQualityGradations = this.neuron.getWeightsVector().getSize() - unselectedGradationsAmount;
        this.correctionsThreshold = this.neuron.getWeightsSum() / (float)potentialNeededItemsQualityGradations;
    }
    
    
    /**
     * Interface for correcting of Neuron.
     */
    public void correctNeuron() {
        
        int size = this.selectedIndices.length;
        for (int i = 0; i < size; i++) {
            
            int itemsIndex = this.selectedIndices[i];
            Vector inputSignalsVector = this.loot.getItem(itemsIndex).getSignalsVector();
            
            float state = this.neuron.calculateState(inputSignalsVector);
            float delta = this.correctionsThreshold - state;
            
            if (delta > 0) {
                Vector deltaWeightsVector = this.generateDeltaWeightsVector(inputSignalsVector, delta);
                
                this.neuron.correctWeights(deltaWeightsVector);
            }
            
        }
        
    }
    
    
    
    /**
     * Generating delta weights vector.
     * @param inputSignalsVector
     * @param delta
     * @return 
     */
    private Vector generateDeltaWeightsVector(Vector inputSignalsVector, float delta) {
        
        int size = inputSignalsVector.getSize();
        Vector result = new Vector(size);
        
        for (int i = 0; i < size; i++) {
            float value = inputSignalsVector.getValue(i) * delta;
            result.setValue(value, i);
        }
        
        return result;
    }
    
}
