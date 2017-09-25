/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */
package loot_list;



import java.util.Random;

import neural_network.Vector;



/**
 * Class Item contains information about Quality.
 * Output quality as String.
 * Generate input signals vector for neural network.
 */
public class Item {
    
    public enum Quality {BAD, COMMON, GOOD, RARE, EPIC, SET};
    
    
    
    private Quality quality;
    private final int QualitiesGradationAmount = 6;
    
    
    
    /**
     * Constructor.
     * Making Item with known quality.
     * @param quality 
     */
    public Item(Quality quality) {
        this.quality = quality;
    }
    
    /**
     * Constructor.
     * Making Item with random quality
     */
    public Item() {
        this.quality = this.generateRandomQuality();
    }
    
    
    
    /**
     * Interface for quality as String.
     * @return 
     */
    public String getQualityTitle() {
        return this.qualityToString();
    }
    
    /**
     * Interface for signals vector.
     * @return 
     */
    public Vector getSignalsVector() {
        return this.createSignalsVector();
    }
    
    /**
     * Interface for index of quality gradation.
     * @return 
     */
    public int getQualityGradationIndex() {
        return this.quality.ordinal();
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
    private Vector createSignalsVector() {
        int size = this.QualitiesGradationAmount + 1;
        Vector result = new Vector(size);
        
        int indexOfQuality = this.quality.ordinal();
        float value = 1f;
        result.setValue(value, indexOfQuality);
        
        return result;
    }
    
    /**
     * Generating random QualitiesGradation.
     * @return 
     */
    private Quality generateRandomQuality() {
        Quality result = Quality.SET;
        int index = this.generateRandomQualitiesIndex();
        
        switch (index) {
            case 0:
                result = Quality.BAD;
                break;
            case 1:
                result = Quality.COMMON;
                break;
            case 2:
                result = Quality.GOOD;
                break;
            case 3:
                result = Quality.RARE;
                break;
            case 4:
                result = Quality.EPIC;
        }
        
        return result;
    }
    
    /**
     * Generating random index of QualitiesGradation.
     * @return 
     */
    private int generateRandomQualitiesIndex() {
        Random random = new Random();
        
        return random.nextInt(this.QualitiesGradationAmount);
    }
}
