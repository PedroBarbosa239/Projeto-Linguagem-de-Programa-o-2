/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;
import entidade.SerMágicoRaçaInteligente.Tendência;
/**
 *
 * @author Familia
 */
public class PainelFiltrosSerMágicoRaçaInteligente extends javax.swing.JPanel {

    /**
     * Creates new form PainelFiltrosSerMágicoRaçaInteligente
     */
    public PainelFiltrosSerMágicoRaçaInteligente() {
        initComponents();
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
        tendenciaButtonGroup.clearSelection();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tendenciaButtonGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        neutroRadioButton = new javax.swing.JRadioButton();
        caóticoRadioButton = new javax.swing.JRadioButton();
        bomRadioButton = new javax.swing.JRadioButton();

        jLabel2.setText("Tendência");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        neutroRadioButton.setMnemonic('\u0001');
        neutroRadioButton.setText("Neutro");
        neutroRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neutroRadioButtonActionPerformed(evt);
            }
        });

        caóticoRadioButton.setText("Caótico");
        caóticoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caóticoRadioButtonActionPerformed(evt);
            }
        });

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
                .addContainerGap(15, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void neutroRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neutroRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_neutroRadioButtonActionPerformed

    private void caóticoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caóticoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caóticoRadioButtonActionPerformed

    private void bomRadioButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bomRadioButton
        // TODO add your handling code here:
    }//GEN-LAST:event_bomRadioButton


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bomRadioButton;
    private javax.swing.JRadioButton caóticoRadioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton neutroRadioButton;
    private javax.swing.ButtonGroup tendenciaButtonGroup;
    // End of variables declaration//GEN-END:variables
}
