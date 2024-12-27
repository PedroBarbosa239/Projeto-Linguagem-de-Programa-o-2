/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import persistência.BD;
import javax.swing.JOptionPane;
import controle.ControladorCadastroItens;
import controle.ControladorCadastroSeresMágicos;
import controle.ControladorCadastroBolsas;
import controle.ControladorCadastroPersonagens;
import interfaces.JanelaPesquisarPersonagens;
/**
 *
 * @author alvaro.olazar
 */
public class JanelaPersonagensRpg extends javax.swing.JFrame {

    /**
     * Creates new form JanelaNovosCelulares
     */
    public JanelaPersonagensRpg() {
        BD.criaConexão();
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personagensRpgMenuBar = new javax.swing.JMenuBar();
        itemMenu = new javax.swing.JMenu();
        cadastrar_itemMenuItem = new javax.swing.JMenuItem();
        serMágicoMenu = new javax.swing.JMenu();
        cadastrar_serMágicoMenuItem = new javax.swing.JMenuItem();
        bolsaMenu = new javax.swing.JMenu();
        cadastrar_bolsaMenuItem = new javax.swing.JMenuItem();
        personagemMenu = new javax.swing.JMenu();
        cadastrar_personagemMenuItem = new javax.swing.JMenuItem();
        pesquisar_personagemMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personagens RPG");
        setPreferredSize(new java.awt.Dimension(400, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                terminarSistema(evt);
            }
        });

        itemMenu.setText("Item");
        itemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarItem(evt);
            }
        });

        cadastrar_itemMenuItem.setText("Cadastrar");
        cadastrar_itemMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarItem(evt);
            }
        });
        itemMenu.add(cadastrar_itemMenuItem);

        personagensRpgMenuBar.add(itemMenu);

        serMágicoMenu.setText("Ser Mágico");

        cadastrar_serMágicoMenuItem.setText("Cadastrar");
        cadastrar_serMágicoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarSerMágico(evt);
            }
        });
        serMágicoMenu.add(cadastrar_serMágicoMenuItem);

        personagensRpgMenuBar.add(serMágicoMenu);

        bolsaMenu.setText("Bolsa");

        cadastrar_bolsaMenuItem.setText("Cadastrar");
        cadastrar_bolsaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBolsa(evt);
            }
        });
        bolsaMenu.add(cadastrar_bolsaMenuItem);

        personagensRpgMenuBar.add(bolsaMenu);

        personagemMenu.setText("Personagem");

        cadastrar_personagemMenuItem.setText("Cadastrar");
        cadastrar_personagemMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPersonagem(evt);
            }
        });
        personagemMenu.add(cadastrar_personagemMenuItem);

        pesquisar_personagemMenuItem.setText("Pesquisar");
        pesquisar_personagemMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarPersonagens(evt);
            }
        });
        personagemMenu.add(pesquisar_personagemMenuItem);

        personagensRpgMenuBar.add(personagemMenu);

        setJMenuBar(personagensRpgMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void terminarSistema(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_terminarSistema
        BD.fechaConexão();
        System.exit(0);
    }//GEN-LAST:event_terminarSistema

    private void informarServiçoIndisponível() {
       JOptionPane.showMessageDialog (this, "Serviço Indisponível", "Informação",
       JOptionPane.INFORMATION_MESSAGE);
    }

    private void pesquisarPersonagens(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarPersonagens
        new JanelaPesquisarPersonagens().setVisible(true);
    }//GEN-LAST:event_pesquisarPersonagens

    private void cadastrarItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarItem
        new ControladorCadastroItens();
    }//GEN-LAST:event_cadastrarItem

    private void cadastrarBolsa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBolsa
        new ControladorCadastroBolsas();
    }//GEN-LAST:event_cadastrarBolsa

    private void cadastrarPersonagem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPersonagem
        new ControladorCadastroPersonagens();
    }//GEN-LAST:event_cadastrarPersonagem

    private void cadastrarSerMágico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarSerMágico
        new ControladorCadastroSeresMágicos();
    }//GEN-LAST:event_cadastrarSerMágico

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
            java.util.logging.Logger.getLogger(JanelaPersonagensRpg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPersonagensRpg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPersonagensRpg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPersonagensRpg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPersonagensRpg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bolsaMenu;
    private javax.swing.JMenuItem cadastrar_bolsaMenuItem;
    private javax.swing.JMenuItem cadastrar_itemMenuItem;
    private javax.swing.JMenuItem cadastrar_personagemMenuItem;
    private javax.swing.JMenuItem cadastrar_serMágicoMenuItem;
    private javax.swing.JMenu itemMenu;
    private javax.swing.JMenu personagemMenu;
    private javax.swing.JMenuBar personagensRpgMenuBar;
    private javax.swing.JMenuItem pesquisar_personagemMenuItem;
    private javax.swing.JMenu serMágicoMenu;
    // End of variables declaration//GEN-END:variables
}
