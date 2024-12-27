/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import javax.swing.JOptionPane;
import controle.ControladorCadastroItens;
import entidade.Item;
import javax.swing.DefaultComboBoxModel;

public class JanelaCadastrarItens extends javax.swing.JFrame {

    ControladorCadastroItens controlador;
    Item[] itens_cadastrados;

   
          
    public JanelaCadastrarItens(ControladorCadastroItens controlador) {
        this.controlador = controlador;
        itens_cadastrados = Item.getVisões();   

        initComponents();
        limparCampos();
    }
    
    @SuppressWarnings("unchecked")
    
      private Item obterItemInformado() {
        String nome = nomeTextField.getText();
        if (nome.isEmpty()){ 
            return null;}   
        

        String peso_str = pesoTextField.getText();
        int peso = 0;
        if (!peso_str.isEmpty()) peso = Integer.parseInt(peso_str);
        else return null;
        
        
        String valor_str = valorTextField.getText();
        int valor = 0;
        if (!valor_str.isEmpty()) valor = Integer.parseInt(valor_str);
        else return null;
        
        String quantidade_str = quantidadeTextField.getText();
        int quantidade = 0;
        if (!quantidade_str.isEmpty()) quantidade = Integer.parseInt(quantidade_str);
        else return null;
        
        
        boolean consumivel = consumivelCheckBox.isSelected();
        
       
        return new Item(nome, peso, valor, quantidade, consumivel);
    }
    
    private void limparCampos() {
        nomeTextField.setText("");
        pesoTextField.setText("");
        valorTextField.setText("");
        quantidadeTextField.setText("");
        consumivelCheckBox.setSelected(false);
    }
 
    private void informarErro (String mensagem) {
        JOptionPane.showMessageDialog (this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    

    private void atualizarComboBox() {
        itens_cadastrados = Item.getVisões();
        itens_cadastradosComboBox.setModel(new DefaultComboBoxModel(itens_cadastrados));
    }
    
    private Item getVisãoAlterada(String nome) {
         for(Item visão : itens_cadastrados){
             if(visão.getNome().equals(nome)){
                 return visão;
             }
         }
         return null;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itens_cadastradosLabel = new javax.swing.JLabel();
        itens_cadastradosComboBox = new javax.swing.JComboBox();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        pesoLabel = new javax.swing.JLabel();
        pesoTextField = new javax.swing.JTextField();
        valorLabel = new javax.swing.JLabel();
        valorTextField = new javax.swing.JTextField();
        quantidadeLabel = new javax.swing.JLabel();
        quantidadeTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        consumivelCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Itens");

        itens_cadastradosLabel.setText("Itens cadastrados:");

        itens_cadastradosComboBox.setModel(new DefaultComboBoxModel(itens_cadastrados));
        itens_cadastradosComboBox.setToolTipText("");
        itens_cadastradosComboBox.setPreferredSize(new java.awt.Dimension(400, 32));
        itens_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itens_cadastradosComboBoxActionPerformed(evt);
            }
        });

        nomeLabel.setText("Nome:");

        nomeTextField.setMinimumSize(new java.awt.Dimension(400, 32));

        pesoLabel.setText("Peso");

        pesoTextField.setMinimumSize(new java.awt.Dimension(400, 32));

        valorLabel.setText("Valor:");
        valorLabel.setToolTipText("");

        valorTextField.setMinimumSize(new java.awt.Dimension(400, 32));
        valorTextField.setPreferredSize(new java.awt.Dimension(300, 22));

        quantidadeLabel.setText("Quantidade");

        quantidadeTextField.setMinimumSize(new java.awt.Dimension(400, 32));

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirItem(evt);
            }
        });
        comandosPanel.add(inserirButton);

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarItem(evt);
            }
        });
        comandosPanel.add(consultarButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarItem(evt);
            }
        });
        comandosPanel.add(alterarButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerItem(evt);
            }
        });
        comandosPanel.add(removerButton);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });
        comandosPanel.add(limparButton);

        consumivelCheckBox.setText("Consumivel");
        consumivelCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        consumivelCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumivelCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(itens_cadastradosLabel)
                        .addGap(12, 12, 12)
                        .addComponent(itens_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeLabel)
                                .addGap(64, 64, 64)
                                .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pesoLabel)
                                .addGap(75, 75, 75)
                                .addComponent(pesoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valorLabel)
                                .addGap(70, 70, 70)
                                .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(consumivelCheckBox)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(quantidadeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(quantidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itens_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itens_cadastradosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(nomeLabel))
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(pesoLabel))
                    .addComponent(pesoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(valorLabel))
                    .addComponent(valorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(quantidadeLabel))
                    .addComponent(quantidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(consumivelCheckBox)
                .addGap(52, 52, 52)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirItem
        Item item = obterItemInformado();
        String mensagem_erro = null;
        if (item != null) {
            mensagem_erro = controlador.inserirItem(item);
        } else {
            mensagem_erro = "Algum atributo do item não foi informado";
        }

        if (mensagem_erro == null) {
            Item visão = item.getVisão();
            itens_cadastradosComboBox.addItem(visão);
            itens_cadastradosComboBox.setSelectedItem(visão);
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_inserirItem

    private void consultarItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarItem
        Item visão = (Item) itens_cadastradosComboBox.getSelectedItem();
        Item item = null;
        String mensagem_erro = null;
        if (visão != null) {
            item = Item.buscarItem(visão.getNome());
            if (item == null) {
                mensagem_erro = "item não cadastrado";
            }
        } else {
            mensagem_erro = "Nenhum item selecionado";
        }
        if (mensagem_erro == null) {
            nomeTextField.setText(item.getNome());
            int peso = item.getPeso();
            Integer tempPeso = (peso == 0) ? null : peso;
           if (tempPeso == null) {
               peso = 0;
           }
            pesoTextField.setText(peso + "");
            valorTextField.setText(item.getValor() + "");
            quantidadeTextField.setText(item.getQuantidade() + "");
            consumivelCheckBox.setSelected(item.getConsumivel());
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_consultarItem

    private void alterarItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarItem
        Item item = obterItemInformado();
        String mensagem_erro = null;
        if (item != null) mensagem_erro = controlador.alterarItem(item);
        else mensagem_erro = "Algum atributo do item não foi informado";
        if (mensagem_erro == null) {
            Item visão = getVisãoAlterada(item.getNome());
            if (visão != null) {
                visão.setPeso(item.getPeso());
                itens_cadastradosComboBox.updateUI();
                itens_cadastradosComboBox.setSelectedItem(visão);
            }  
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_alterarItem

    private void removerItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerItem
        Item visão = (Item) itens_cadastradosComboBox.getSelectedItem ();
        String mensagem_erro = null;
        if (visão != null) mensagem_erro = controlador.removerItem(visão.getNome());
        else mensagem_erro = "Nenhum celular selecionado";
        if (mensagem_erro == null) {
            itens_cadastradosComboBox.removeItem(visão);
            limparCampos();
        } else informarErro (mensagem_erro);;
    }//GEN-LAST:event_removerItem

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    private void consumivelCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumivelCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consumivelCheckBoxActionPerformed

    private void itens_cadastradosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itens_cadastradosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itens_cadastradosComboBoxActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JCheckBox consumivelCheckBox;
    private javax.swing.JButton inserirButton;
    private javax.swing.JComboBox itens_cadastradosComboBox;
    private javax.swing.JLabel itens_cadastradosLabel;
    private javax.swing.JButton limparButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel pesoLabel;
    private javax.swing.JTextField pesoTextField;
    private javax.swing.JLabel quantidadeLabel;
    private javax.swing.JTextField quantidadeTextField;
    private javax.swing.JButton removerButton;
    private javax.swing.JLabel valorLabel;
    private javax.swing.JTextField valorTextField;
    // End of variables declaration//GEN-END:variables
}
