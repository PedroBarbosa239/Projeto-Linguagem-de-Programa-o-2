/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import entidade.SerMágicoRaçaInteligente.Habitat;
import entidade.SerMágicoRaçaInteligente.Tendência;
import javax.swing.DefaultComboBoxModel;


public class PainelSerMágicoRaçaInteligente extends javax.swing.JPanel {

    /**
     * Creates new form PainelSerMágicoRaçaInteligente
     */
    public PainelSerMágicoRaçaInteligente() {
        initComponents();
    }
    public Habitat getSelectedhabitat() {
        Object habitat = habitatComboBox.getSelectedItem();
        if (habitat != null) return (Habitat) habitat;
        else return null;
    }
    public void setSelectedgetSelectedhabitat(Habitat habitat) {
    habitatComboBox.setSelectedItem(habitat);
    }
    
    public Tendência getSelectedTendencia() {
        Tendência tendencia = null;
        if (tendenciaButtonGroup.getSelection() != null)
            tendencia = Tendência.values()[tendenciaButtonGroup.getSelection().getMnemonic()];
        return tendencia;
    }
    public void setSelectedTendencia(int índice_tendencia) {
        switch(índice_tendencia) {
            case 0: caóticoRadioButton.setSelected(true); break;
            case 1: neutroRadioButton.setSelected(true);
            case 2: bomRadioButton.setSelected(true);
        }
    }
    
    public void limparCampos() {
        habitatComboBox.setSelectedIndex(-1);
        tendenciaButtonGroup.clearSelection();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tendenciaButtonGroup = new javax.swing.ButtonGroup();
        habitatComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        neutroRadioButton = new javax.swing.JRadioButton();
        caóticoRadioButton = new javax.swing.JRadioButton();
        bomRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        habitatComboBox.setModel(new DefaultComboBoxModel (Habitat.values()));
        habitatComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitatComboBox(evt);
            }
        });

        tendenciaButtonGroup.add(neutroRadioButton);
        neutroRadioButton.setMnemonic('\u0001');
        neutroRadioButton.setText("Neutro");
        neutroRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neutroRadioButtonActionPerformed(evt);
            }
        });

        tendenciaButtonGroup.add(caóticoRadioButton);
        caóticoRadioButton.setText("Caótico");
        caóticoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caóticoRadioButtonActionPerformed(evt);
            }
        });

        tendenciaButtonGroup.add(bomRadioButton);
        bomRadioButton.setMnemonic('\u0002');
        bomRadioButton.setText("Bom");
        bomRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bomRadioButton(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(caóticoRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(neutroRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bomRadioButton)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(neutroRadioButton)
                    .addComponent(caóticoRadioButton)
                    .addComponent(bomRadioButton)))
        );

        jLabel1.setText("Habitat");

        jLabel2.setText("Tendência");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(habitatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(habitatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void caóticoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caóticoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caóticoRadioButtonActionPerformed

    private void neutroRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neutroRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_neutroRadioButtonActionPerformed

    private void habitatComboBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habitatComboBox
        // TODO add your handling code here:
    }//GEN-LAST:event_habitatComboBox

    private void bomRadioButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bomRadioButton
        // TODO add your handling code here:
    }//GEN-LAST:event_bomRadioButton


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bomRadioButton;
    private javax.swing.JRadioButton caóticoRadioButton;
    private javax.swing.JComboBox<String> habitatComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton neutroRadioButton;
    private javax.swing.ButtonGroup tendenciaButtonGroup;
    // End of variables declaration//GEN-END:variables
}
