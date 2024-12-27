
package interfaces;
import javax.swing.JOptionPane;
import controle.ControladorCadastroSeresMágicos;
import entidade.SerMágico;
import entidade.SerMágico.HabilidadeMágica;
import entidade.SerMágicoMonstro;
import entidade.SerMágicoRaçaInteligente;
import entidade.SerMágicoRaçaInteligente.Habitat;
import entidade.SerMágicoRaçaInteligente.Tendência;


import javax.swing.DefaultComboBoxModel;


public class JanelaCadastrarSeresMágicos extends javax.swing.JFrame {

    ControladorCadastroSeresMágicos controlador;
    SerMágico[] seres_mágicos_cadastrados;
    PainelSerMágicoMonstro serMágico_monstroPainel;
    PainelSerMágicoRaçaInteligente serMágico_raçaInteligentePainel;
          
    public JanelaCadastrarSeresMágicos(ControladorCadastroSeresMágicos controlador) {
        this.controlador = controlador;
        seres_mágicos_cadastrados = SerMágico.getVisões();    
        initComponents();
        serMágico_monstroPainel = new PainelSerMágicoMonstro();
        serMágico_raçaInteligentePainel = new PainelSerMágicoRaçaInteligente();
        especialização_serMagicoTabbedPane.addTab("Ser Mágico Monstro",serMágico_monstroPainel);
        especialização_serMagicoTabbedPane.addTab("Ser Mágico Raça Inteligente",serMágico_raçaInteligentePainel);
        limparCampos(null);
    }

    @SuppressWarnings("unchecked")
  
    
    private SerMágico obterSerMágicoInformado() {
        String nome = nomeTextField.getText();
        if (nome.isEmpty()){ 
            return null;
      }
        HabilidadeMágica habilidade = null;
        if (habilidadeButtonGroup.getSelection() != null)
        habilidade = HabilidadeMágica.values()[habilidadeButtonGroup.getSelection().getMnemonic()];
        else return null;
        
        SerMágico sermágico = null;
        int índice_aba_secionada = especialização_serMagicoTabbedPane.getSelectedIndex();
        switch (índice_aba_secionada) {
            case 0:
                boolean hostilSerMágico = serMágico_monstroPainel.isHostilMonstro();
               
                int danoAdicionalSerMágico = serMágico_monstroPainel.getDanoAdicionalMonstro();
                if (danoAdicionalSerMágico == -1) return null;
                
                
                sermágico = new SerMágicoMonstro(nome,habilidade,hostilSerMágico,danoAdicionalSerMágico);
                break;
            case 1:
                Tendência tendênciaRaça = serMágico_raçaInteligentePainel.getSelectedTendencia();
                Habitat habitatRaça = serMágico_raçaInteligentePainel.getSelectedhabitat();
                sermágico = new SerMágicoRaçaInteligente(nome,habilidade,tendênciaRaça,habitatRaça);
    }
        return sermágico;
    }
    
    private void informarErro (String mensagem){
        JOptionPane.showMessageDialog (this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    private SerMágico getVisãoAlterada(String nome) {
         for(SerMágico visão : seres_mágicos_cadastrados){
             if(visão.getNome().equals(nome)){
                 return visão;
             }
         }
         return null;
    }
    
    private void limparCampos() {
        nomeTextField.setText("");
        habilidadeButtonGroup.clearSelection();
        serMágico_monstroPainel.limparCampos();
        serMágico_raçaInteligentePainel.limparCampos();
    }
    
    private void selecionarHabilidadeRadioButton(int índice_habilidade_mágica) {
        switch(índice_habilidade_mágica) {
            case 0: proeficiênciaRadioButton.setSelected(true);
            break;
            case 1: fortalecimentoRadioButton.setSelected(true);
            break;
            case 2: sobreCargaRadioButton.setSelected(true);
            break;
            case 3: vooRadioButton.setSelected(true);
        }
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        habilidadeButtonGroup = new javax.swing.ButtonGroup();
        seres_magicos_cadastradosLabel = new javax.swing.JLabel();
        seres_magicos_cadastradosComboBox = new javax.swing.JComboBox();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        habilidadeMagicaLabel = new javax.swing.JLabel();
        comandosPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        proeficiênciaRadioButton = new javax.swing.JRadioButton();
        fortalecimentoRadioButton = new javax.swing.JRadioButton();
        sobreCargaRadioButton = new javax.swing.JRadioButton();
        vooRadioButton = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        especialização_serMagicoTabbedPane = new javax.swing.JTabbedPane();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Seres Mágicos");

        seres_magicos_cadastradosLabel.setText("Seres Mágicos cadastrados:");

        seres_magicos_cadastradosComboBox.setModel(new DefaultComboBoxModel(seres_mágicos_cadastrados));
        seres_magicos_cadastradosComboBox.setPreferredSize(new java.awt.Dimension(400, 32));
        seres_magicos_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seres_magicos_cadastradosComboBoxActionPerformed(evt);
            }
        });

        nomeLabel.setText("Nome:");

        nomeTextField.setPreferredSize(new java.awt.Dimension(400, 32));
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });

        habilidadeMagicaLabel.setText("Habildade Mágica:");

        habilidadeButtonGroup.add(proeficiênciaRadioButton);
        proeficiênciaRadioButton.setText("Proeficiência");
        proeficiênciaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proeficiênciaRadioButtonActionPerformed(evt);
            }
        });
        jPanel1.add(proeficiênciaRadioButton);

        habilidadeButtonGroup.add(fortalecimentoRadioButton);
        fortalecimentoRadioButton.setMnemonic('\u0001');
        fortalecimentoRadioButton.setText("Fortalecimento");
        jPanel1.add(fortalecimentoRadioButton);

        habilidadeButtonGroup.add(sobreCargaRadioButton);
        sobreCargaRadioButton.setMnemonic('\u0002');
        sobreCargaRadioButton.setText("Sobre-carga");
        jPanel1.add(sobreCargaRadioButton);

        habilidadeButtonGroup.add(vooRadioButton);
        vooRadioButton.setMnemonic('\u0003');
        vooRadioButton.setText("Voo");
        jPanel1.add(vooRadioButton);

        jRadioButton4.setText("Passos de Pena");
        jPanel1.add(jRadioButton4);

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirSerMágico(evt);
            }
        });

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarSerMágico(evt);
            }
        });

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarSerMágico(evt);
            }
        });

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerSerMágico(evt);
            }
        });

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(seres_magicos_cadastradosLabel)
                .addGap(29, 29, 29)
                .addComponent(seres_magicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(nomeLabel)
                .addGap(137, 137, 137)
                .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(habilidadeMagicaLabel)
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(especialização_serMagicoTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inserirButton)
                .addGap(5, 5, 5)
                .addComponent(consultarButton)
                .addGap(5, 5, 5)
                .addComponent(alterarButton)
                .addGap(5, 5, 5)
                .addComponent(removerButton)
                .addGap(5, 5, 5)
                .addComponent(limparButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(seres_magicos_cadastradosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seres_magicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(nomeLabel))
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(habilidadeMagicaLabel)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(especialização_serMagicoTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inserirButton)
                        .addComponent(consultarButton)
                        .addComponent(alterarButton)
                        .addComponent(removerButton)
                        .addComponent(limparButton))))
        );

        getAccessibleContext().setAccessibleName("Cadastrar Shopping");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    private void removerSerMágico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerSerMágico
        SerMágico visão = (SerMágico) seres_magicos_cadastradosComboBox.getSelectedItem ();
        String mensagem_erro = null;
        if (visão != null) mensagem_erro = controlador.removerSerMágico(visão);
        else mensagem_erro = "Nenhum Ser Mágico selecionado";
        if (mensagem_erro == null) {
            seres_magicos_cadastradosComboBox.removeItem(visão);
            limparCampos();
        } else informarErro (mensagem_erro);;
    }//GEN-LAST:event_removerSerMágico

    private void alterarSerMágico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarSerMágico
        SerMágico ser_mágico = obterSerMágicoInformado();
        String mensagem_erro = null;
        if (ser_mágico != null) mensagem_erro = controlador.alterarSerMágico(ser_mágico);
        else mensagem_erro = "Algum atributo do Ser Mágico não foi informado";
        if (mensagem_erro == null) {
            SerMágico visão = getVisãoAlterada(ser_mágico.getNome());
            if (visão != null) {        
                visão.setNome(ser_mágico.getNome());
                if (ser_mágico instanceof SerMágicoMonstro) {
                    SerMágicoMonstro serMágico_monstro = (SerMágicoMonstro) ser_mágico;
                    SerMágicoMonstro visão_monstro   = (SerMágicoMonstro) visão;

                    visão_monstro.setHostilMonstro(serMágico_monstro.getHostil());
                    
                } else if(ser_mágico instanceof SerMágicoRaçaInteligente) {
                    SerMágicoRaçaInteligente serMágico_raça = (SerMágicoRaçaInteligente) ser_mágico;
                    SerMágicoRaçaInteligente visão_raça = (SerMágicoRaçaInteligente) visão;
                    
                    visão_raça.setTendência(serMágico_raça.getTendência());
                    visão_raça.setHabitat(serMágico_raça.getHabitat());
                }
                
                seres_magicos_cadastradosComboBox.updateUI();
                
                
            }  
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_alterarSerMágico

    private void consultarSerMágico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarSerMágico
        SerMágico visão = (SerMágico) seres_magicos_cadastradosComboBox.getSelectedItem ();
        SerMágico ser_mágico = null;
        String mensagem_erro = null;
        if (visão != null) {
            ser_mágico = SerMágico.buscarSerMágico(visão.getNome());
            if (ser_mágico == null) mensagem_erro = "Ser Mágico não cadastrado";
        } else mensagem_erro = "Nenhum Ser Mágico selecionado";
        if (mensagem_erro == null) {
            nomeTextField.setText(ser_mágico.getNome());
            selecionarHabilidadeRadioButton(ser_mágico.getHabilidadeMagica().ordinal());
            
            if(ser_mágico instanceof SerMágicoMonstro) {
                especialização_serMagicoTabbedPane.setSelectedIndex(0);
                SerMágicoMonstro serMágico_monstro = (SerMágicoMonstro) ser_mágico;
                
                serMágico_monstroPainel.setHostilMonstro
                (serMágico_monstro.getHostil());
                
                serMágico_monstroPainel.setDanoAdicionalMonstro
                (serMágico_monstro.getDanoAdicional());
                
            } else if (ser_mágico instanceof SerMágicoRaçaInteligente) {
                especialização_serMagicoTabbedPane.setSelectedIndex(1);
                SerMágicoRaçaInteligente serMágico_raça = (SerMágicoRaçaInteligente) ser_mágico;
                
                serMágico_raçaInteligentePainel.setSelectedTendencia
                (serMágico_raça.getTendência().ordinal());
                
                serMágico_raçaInteligentePainel.setSelectedgetSelectedhabitat
                (serMágico_raça.getHabitat());
            }
        } else informarErro (mensagem_erro);
        
        
    }//GEN-LAST:event_consultarSerMágico

    private void inserirSerMágico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirSerMágico
        SerMágico ser_mágico = obterSerMágicoInformado();
        String mensagem_erro = null;
        if (ser_mágico != null) mensagem_erro = controlador.inserirSerMágico(ser_mágico);
        else mensagem_erro = "Algum atributo do Ser Mágico não foi informado";
        
        if (mensagem_erro == null) {
            SerMágico visão = ser_mágico.getVisão();
            seres_magicos_cadastradosComboBox.addItem(visão);
            seres_magicos_cadastradosComboBox.setSelectedItem(visão);   
        } else informarErro (mensagem_erro);
    }//GEN-LAST:event_inserirSerMágico

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextFieldActionPerformed

    private void seres_magicos_cadastradosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seres_magicos_cadastradosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seres_magicos_cadastradosComboBoxActionPerformed

    private void proeficiênciaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proeficiênciaRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proeficiênciaRadioButtonActionPerformed

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
    private javax.swing.JTabbedPane especialização_serMagicoTabbedPane;
    private javax.swing.JRadioButton fortalecimentoRadioButton;
    private javax.swing.ButtonGroup habilidadeButtonGroup;
    private javax.swing.JLabel habilidadeMagicaLabel;
    private javax.swing.JButton inserirButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton limparButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JRadioButton proeficiênciaRadioButton;
    private javax.swing.JButton removerButton;
    private javax.swing.JComboBox seres_magicos_cadastradosComboBox;
    private javax.swing.JLabel seres_magicos_cadastradosLabel;
    private javax.swing.JRadioButton sobreCargaRadioButton;
    private javax.swing.JRadioButton vooRadioButton;
    // End of variables declaration//GEN-END:variables
}
