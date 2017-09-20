/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package gui_frames;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

import loot_list.*;
import neural_network.*;

public class LootListPanel extends javax.swing.JPanel {

    /**
     * Creates new form LootListPanel
     */
    public LootListPanel() {
        initComponents();
    }
    
    
    /**
     * Interface for displaying Loot List
     * @param loot 
     */
    public void displayLoot(LootList loot) {
        this.lootList.clearSelection();
        
        DefaultListModel model = new DefaultListModel();
        model.clear();
        
        int size = loot.getSize();
        for (int i = 0; i < size; i++) {
            String itemTitle = loot.getItem(i).getQualityTitle();
            itemTitle += " Item";
            model.addElement(itemTitle);
        }
        
        this.lootList.setModel(model);
    }   
    
    /**
     * Displaying selections
     * @param loot
     * @param neuron
     * @param thresholdSelecting 
     */
    public void setSelections(LootList loot, Neuron neuron, float thresholdSelecting) {        
        List<Integer> selectionsList = new ArrayList<>();
        
        int size = loot.getSize();
        for (int i = 0; i < size; i++) {
            Vector inputSignals = loot.getItem(i).getSignalsVector();
            float state = neuron.calculateState(inputSignals);
            if (state >= thresholdSelecting) {
                selectionsList.add(i);
            }
        }
        
        size = selectionsList.size();
        int[] selectedIndices = new int[size];
        for (int i = 0; i < size; i++) {
            selectedIndices[i] = selectionsList.get(i);
        }
        
        this.lootList.setSelectedIndices(selectedIndices);
    }
    
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lootList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        selectAllButton = new javax.swing.JButton();
        resetSelectionButton = new javax.swing.JButton();

        lootList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "bad Item", "common Item", "good Item", "rare Item", "epic Item", "set Item", "bad Item", "common Item", "good Item", "rare Item" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lootList);

        jLabel1.setText("Loot List");

        selectAllButton.setText("select All");
        selectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllButtonActionPerformed(evt);
            }
        });

        resetSelectionButton.setText("reset Selection");
        resetSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSelectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(selectAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resetSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetSelectionButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void selectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllButtonActionPerformed
        
        int itemsAmount = this.lootList.getModel().getSize();
        int[] selectedIndices = new int[itemsAmount];
        for (int i = 0; i < itemsAmount; i++) {
            selectedIndices[i] = i;
        }
        this.lootList.setSelectedIndices(selectedIndices);
        
    }//GEN-LAST:event_selectAllButtonActionPerformed

    private void resetSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSelectionButtonActionPerformed
        this.lootList.clearSelection();
    }//GEN-LAST:event_resetSelectionButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lootList;
    private javax.swing.JButton resetSelectionButton;
    private javax.swing.JButton selectAllButton;
    // End of variables declaration//GEN-END:variables
}
