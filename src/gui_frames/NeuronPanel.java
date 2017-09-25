/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */
package gui_frames;

import neural_network.Neuron;
import neural_network.Vector;

public class NeuronPanel extends javax.swing.JPanel {

    private final int weightsAmount = 7;
    
    private final float maxValue = 100f;
    
    
    
    /**
     * Creates new form NeuronPanel
     */
    public NeuronPanel() {
        initComponents();
    }
    
    
    
    public void displayWeights(Neuron neuron) throws RuntimeException {
        Vector weights = neuron.getWeightsVector();
        int size = weights.getSize();
        if (size == this.weightsAmount) {
            
            this.badProgressBar.    setValue(this.calculateDisplayedValue(weights.getValue(0)));
            this.commonProgressBar. setValue(this.calculateDisplayedValue(weights.getValue(1)));
            this.goodProgressBar.   setValue(this.calculateDisplayedValue(weights.getValue(2)));
            this.rareProgressBar.   setValue(this.calculateDisplayedValue(weights.getValue(3)));
            this.epicProgressBar.   setValue(this.calculateDisplayedValue(weights.getValue(4)));
            this.setProgressBar.    setValue(this.calculateDisplayedValue(weights.getValue(5)));
            this.nothingProgressBar.setValue(this.calculateDisplayedValue(weights.getValue(6)));
            
            
        } else {
            throw new RuntimeException("weights amount must be 7");
        }
    }
    
    
    
    private int calculateDisplayedValue(float value) {
        int result = (int) (this.maxValue * value);
        
        return result;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        badProgressBar = new javax.swing.JProgressBar();
        commonProgressBar = new javax.swing.JProgressBar();
        goodProgressBar = new javax.swing.JProgressBar();
        rareProgressBar = new javax.swing.JProgressBar();
        epicProgressBar = new javax.swing.JProgressBar();
        setProgressBar = new javax.swing.JProgressBar();
        nothingProgressBar = new javax.swing.JProgressBar();

        jLabel1.setText("Neuron");

        badProgressBar.setString("bad");
        badProgressBar.setStringPainted(true);

        commonProgressBar.setString("common");
        commonProgressBar.setStringPainted(true);

        goodProgressBar.setString("good");
        goodProgressBar.setStringPainted(true);

        rareProgressBar.setString("rare");
        rareProgressBar.setStringPainted(true);

        epicProgressBar.setString("epic");
        epicProgressBar.setStringPainted(true);

        setProgressBar.setString("set");
        setProgressBar.setStringPainted(true);

        nothingProgressBar.setString("nothing");
        nothingProgressBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(badProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goodProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commonProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rareProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(epicProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nothingProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commonProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goodProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rareProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(epicProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nothingProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar badProgressBar;
    private javax.swing.JProgressBar commonProgressBar;
    private javax.swing.JProgressBar epicProgressBar;
    private javax.swing.JProgressBar goodProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar nothingProgressBar;
    private javax.swing.JProgressBar rareProgressBar;
    private javax.swing.JProgressBar setProgressBar;
    // End of variables declaration//GEN-END:variables
}
