/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import controle.ControladorCadastroPossuirBolsas;
import javax.swing.DefaultListModel;

import javax.swing.JOptionPane;
import controle.ControladorCadastroBolsas;
import entidade.Bolsa;
import entidade.Bolsa.Qualidade;
import entidade.Possuir;
import javax.swing.DefaultComboBoxModel;


public class JanelaCadastrarBolsas extends javax.swing.JFrame {
    ControladorCadastroBolsas controlador;
    Bolsa[] bolsas_cadastrados;
    DefaultListModel item_possuir_bolsa;


    
    public JanelaCadastrarBolsas(ControladorCadastroBolsas controlador) {
        this.controlador = controlador;
        bolsas_cadastrados = Bolsa.getVisões();  
            
        initComponents();
        item_possuir_bolsa = (DefaultListModel) itensList.getModel();
        limparCampos();
 
    }
 private void limparCampos() {
        sequencialTextField.setText("");
        pesoMáximoTextField.setText("");
        item_possuir_bolsa.clear();
        qualidadeComboBox.setSelectedIndex(-1);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    private Bolsa obtémBolsaInformado() {
         String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }
        
            
        String peso_str = pesoMáximoTextField.getText();
        int peso = 0;
        if (!peso_str.isEmpty()) peso = Integer.parseInt(peso_str);
        else return null;
        
        Qualidade qualidade = null;
        if (qualidadeComboBox.getSelectedItem() != null)
        qualidade = (Qualidade)qualidadeComboBox.getSelectedItem();
        else return null;

        return new Bolsa(sequencial, peso, qualidade);
    }
    
     private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void informarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
  private Bolsa getVisãoAlterada(int sequencial) {
        for (Bolsa visão : bolsas_cadastrados) {
            if (visão.getSequencial() == sequencial) {
                return visão;
            }
        }
        return null;
    }
  
    public void atualizarListaPossuirBolsas(int sequencial) {
        item_possuir_bolsa.clear();
        Possuir[] possuir_bolsas = Possuir.buscarPossuirBolsa(sequencial);
        for (Possuir possuir : possuir_bolsas) {
            item_possuir_bolsa.addElement(possuir);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bolsas_cadastradosComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        pesoMáximoTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inserirButtom = new javax.swing.JButton();
        consultarButtom = new javax.swing.JButton();
        removerButtom = new javax.swing.JButton();
        limparButtom = new javax.swing.JButton();
        alterarButtom = new javax.swing.JButton();
        possuirButtom = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sequencialTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itensList = new javax.swing.JList();
        qualidadeComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Bolsas");

        bolsas_cadastradosComboBox.setModel(new DefaultComboBoxModel(bolsas_cadastrados));
        bolsas_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bolsas_cadastradosComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Bolsas Cadastradas:");

        pesoMáximoTextField.setText("peso");
        pesoMáximoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoMáximoTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Peso Máximo:");

        inserirButtom.setText("Inserir");
        inserirButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirBolsa(evt);
            }
        });

        consultarButtom.setText("Consultar");
        consultarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBolsa(evt);
            }
        });

        removerButtom.setText("Remover");
        removerButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerBolsa(evt);
            }
        });

        limparButtom.setText("Limpar");
        limparButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        alterarButtom.setText("Alterar");
        alterarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarBolsa(evt);
            }
        });

        possuirButtom.setText("Possuir");
        possuirButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPossuir(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inserirButtom)
                .addGap(9, 9, 9)
                .addComponent(alterarButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(possuirButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparButtom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirButtom)
                    .addComponent(consultarButtom)
                    .addComponent(removerButtom)
                    .addComponent(limparButtom)
                    .addComponent(alterarButtom)
                    .addComponent(possuirButtom)))
        );

        jLabel3.setText("Serial:");

        sequencialTextField.setEditable(false);
        sequencialTextField.setToolTipText("");
        sequencialTextField.setPreferredSize(new java.awt.Dimension(65, 20));
        sequencialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sequencialTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Itens");

        itensList.setModel(new DefaultListModel());
        itensList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(itensList);

        qualidadeComboBox.setModel(new DefaultComboBoxModel (Qualidade.values()));
        qualidadeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualidadeComboBox(evt);
            }
        });

        jLabel5.setText("Qualidade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel4)
                .addGap(95, 95, 95)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pesoMáximoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qualidadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(bolsas_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(bolsas_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesoMáximoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qualidadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesoMáximoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoMáximoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoMáximoTextFieldActionPerformed

    private void consultarBolsa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBolsa
      Bolsa visão = (Bolsa) bolsas_cadastradosComboBox.getSelectedItem();
        Bolsa bolsa = null;
        String mensagem_erro = null;
        int sequencial = -1;
        if (visão != null) {
            sequencial = visão.getSequencial();
            bolsa = Bolsa.buscarBolsa(sequencial);
            if (bolsa == null) {
                mensagem_erro = "Bolsa não encontrada";
            }
        } else {
            mensagem_erro = "Nenhuma bolsa selecionada";
        }
        if (mensagem_erro == null) {
            sequencialTextField.setText(sequencial + "");
            pesoMáximoTextField.setText(bolsa.getPesoMax() + "");
            qualidadeComboBox.setSelectedItem(bolsa.getQualidade());

            atualizarListaPossuirBolsas(sequencial);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarBolsa

    private void inserirBolsa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirBolsa
            Bolsa bolsa = obtémBolsaInformado();
        String mensagem_erro = null;
        if (bolsa != null) {
            mensagem_erro = controlador.inserirBolsa(bolsa);
        } else {
            mensagem_erro = "Preencha todos os campos";
        }
        if (mensagem_erro == null) {
            int sequencial = Bolsa.últimoSequencial();
            bolsa.setSequencial(sequencial);
            Bolsa visão = bolsa.getVisão();
            bolsas_cadastradosComboBox.addItem(visão);
            bolsas_cadastradosComboBox.setSelectedItem(visão);
            sequencialTextField.setText("" + sequencial);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_inserirBolsa

    private void removerBolsa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerBolsa
        Bolsa visão = (Bolsa) bolsas_cadastradosComboBox.getSelectedItem ();
        String mensagem_erro = null;
        if (visão != null) mensagem_erro = controlador.removerBolsa(visão.getSequencial());
        else mensagem_erro = "Nenhum Bolsa selecionada";
        if (mensagem_erro == null) {
            bolsas_cadastradosComboBox.removeItem(visão);
            limparCampos();
        } else informarErro (mensagem_erro);;
    }//GEN-LAST:event_removerBolsa

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    private void alterarBolsa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarBolsa
        Bolsa bolsa = obtémBolsaInformado();
        String mensagem_erro = null;
        if (bolsa != null) mensagem_erro = controlador.alterarBolsa(bolsa);
        else mensagem_erro = "Algum atributo do Bolsa não foi informado";
        if (mensagem_erro == null) {
            Bolsa visão = getVisãoAlterada(bolsa.getSequencial());
            if (visão != null) {
                visão.setPesoMax(bolsa.getPesoMax());
                bolsas_cadastradosComboBox.updateUI();
                bolsas_cadastradosComboBox.setSelectedItem(visão);
            }  
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_alterarBolsa

    private void bolsas_cadastradosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bolsas_cadastradosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bolsas_cadastradosComboBoxActionPerformed

    private void sequencialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sequencialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sequencialTextFieldActionPerformed

    private void cadastrarPossuir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPossuir
          // TODO add your handling code here:
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }
        if (sequencial > 0){
                new ControladorCadastroPossuirBolsas(this, sequencial);}
        else
            informarErro("Nenhuma Bolsa selecionada");
    }//GEN-LAST:event_cadastrarPossuir

    private void qualidadeComboBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualidadeComboBox
        // TODO add your handling code here:
    }//GEN-LAST:event_qualidadeComboBox

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarBolsas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarBolsas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarBolsas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarBolsas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButtom;
    private javax.swing.JComboBox bolsas_cadastradosComboBox;
    private javax.swing.JButton consultarButtom;
    private javax.swing.JButton inserirButtom;
    private javax.swing.JList itensList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limparButtom;
    private javax.swing.JTextField pesoMáximoTextField;
    private javax.swing.JButton possuirButtom;
    private javax.swing.JComboBox qualidadeComboBox;
    private javax.swing.JButton removerButtom;
    private javax.swing.JTextField sequencialTextField;
    // End of variables declaration//GEN-END:variables
}
