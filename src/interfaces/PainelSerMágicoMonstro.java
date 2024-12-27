/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;



public class PainelSerMágicoMonstro extends javax.swing.JPanel {

    /**
     * Creates new form PainelSerMágicoMonstro
     */
    public PainelSerMágicoMonstro() {
        initComponents();
    }
    
public boolean isHostilMonstro() { return hostilCheckBox.isSelected(); }

public void setHostilMonstro(boolean hostil_monstro) {
    hostilCheckBox.setSelected(hostil_monstro);
}

public int getDanoAdicionalMonstro() {
    String dano_str = danoAdicionalTextField.getText();
    if (!dano_str.isEmpty()) return Integer.parseInt(dano_str);
    else return -1;
}
public void setDanoAdicionalMonstro(int dano) { 
    danoAdicionalTextField.setText(dano + ""); 
   
}

     
    public void limparCampos() {
        hostilCheckBox.setSelected(false);
        danoAdicionalTextField.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        danoAdicionalTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        hostilCheckBox = new javax.swing.JCheckBox();

        danoAdicionalTextField.setMinimumSize(new java.awt.Dimension(100, 22));
        danoAdicionalTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        danoAdicionalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danoAdicionalTextField(evt);
            }
        });

        jLabel2.setText("Dano adicional:");

        hostilCheckBox.setText("Hostil:");
        hostilCheckBox.setToolTipText("");
        hostilCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostilCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        hostilCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostilCheckBox(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(hostilCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(danoAdicionalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(hostilCheckBox)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(danoAdicionalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hostilCheckBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostilCheckBox
        // TODO add your handling code here:
    }//GEN-LAST:event_hostilCheckBox

    private void danoAdicionalTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danoAdicionalTextField
        // TODO add your handling code here:
    }//GEN-LAST:event_danoAdicionalTextField


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField danoAdicionalTextField;
    private javax.swing.JCheckBox hostilCheckBox;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
