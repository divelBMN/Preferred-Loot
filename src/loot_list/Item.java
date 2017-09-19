/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */
package loot_list;

import neural_network.Vector;

/**
 * Class Item contains information about Quality.
 * Output quality as String.
 * Generate input signals vector for neural network.
 */
public class Item {
    
    public enum Quality {BAD, COMMON, GOOD, RARE, EPIC, SET};
    
    
    
    private Quality quality;
    
    
    
    /**
     * Constructor.
     * Making Item with known quality.
     * @param quality 
     */
    public Item(Quality quality) {
        this.quality = quality;
    }
    
    
    
    /**
     * Interface for quality as String.
     * @return 
     */
    public String qualityTitle() {
        return this.qualityToString();
    }
    
    /**
     * Interface for signals vector.
     * @return 
     */
    public Vector signalsVector() {
        return this.getSignalsVector();
    }
    
    
    
    /**
     * Translating quality to String.
     * @return 
     */
    private String qualityToString() {
        String result = "";
        
        switch (quality) {
            case BAD:
                result = "bad";
                break;
            case COMMON:
                result = "common";
                break;
            case GOOD:
                result = "good";
                break;
            case RARE:
                result = "rare";
                break;
            case EPIC:
                result = "epic";
                break;
            case SET:
                result = "set";
        }
        
        return result;
    }
    
    /**
     * Creating signals vector.
     * All values of vector is zero, except for one value, which is 1f.
     * Index of this value is determined by quality of the Item.
     * @return 
     */
    private Vector getSignalsVector() {
        int size = 6;
        Vector result = new Vector(size);
        
        int indexOfQuality = this.quality.ordinal();
        float value = 1f;
        result.setValue(value, indexOfQuality);
        
        return result;
    }
}
