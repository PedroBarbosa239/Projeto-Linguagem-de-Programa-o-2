/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistência.BD;

public class Possuir {
    private int sequencial;
    private Bolsa bolsa;
    private Item item;
    
    public Possuir(int sequencial,  Bolsa bolsa,  Item item) {
        this.sequencial = sequencial;
        this.bolsa = bolsa;
        this.item = item;
    }
    
    public Possuir(int sequencial) {
        this.sequencial = sequencial;
    }

    public Possuir getVisão() {
        return new Possuir(sequencial, bolsa, item);
    }
    
    public static int últimoSequencial() {
        String sql = "SELECT MAX(sequencial) FROM Possuir";
        ResultSet lista_resultados = null;
        int sequencial = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return sequencial;
    }
    
    
    public static Possuir[] getVisões() {
        String sql = "SELECT sequencial, BolsaId, ItemId from Possuir";
        ResultSet lista_resultados = null;
        ArrayList<Possuir> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Possuir(lista_resultados.getInt("sequencial"),
                        Bolsa.buscarBolsa(lista_resultados.getInt("bolsaId")).getVisão(),
                        Item.buscarItem(lista_resultados.getString("itemId")).getVisão()));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Possuir[visões.size()]);
    }
    
     public static boolean existePossuir(int chave_bolsa, String chave_item) {
        String sql = "SELECT Sequencial from Possuir WHERE bolsaId = ? AND itemId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, chave_bolsa);
            comando.setString(2, chave_item);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return existe;
    }
     
     
      public static boolean existePossuir(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) from Possuir WHERE sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return existe;
    }
    
       public static String inserirPossuir(Possuir possuir) {
        String sql = "INSERT INTO Possuir VALUES(?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, possuir.getSequencial());
            comando.setInt(2, possuir.bolsa.getSequencial());
            comando.setString(3, possuir.item.getNome());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro ao adicionar Possuir";
        }
        return null;
    }
       
       
     public static String removerPossuir(int sequencial) {
        System.out.println("Sequencial passado para remoção: " + sequencial);
        String sql = "DELETE FROM Possuir WHERE sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro ao remover possuir";
        }
    }
     
     public static Possuir[] buscarPossuirBolsa(int sequencial_bolsa) {
        String sql = "SELECT * FROM Possuir WHERE bolsaId = ?";
        ArrayList<Possuir> possuis = new ArrayList<>();

        try (PreparedStatement comando = BD.conexão.prepareStatement(sql)) {
            comando.setInt(1, sequencial_bolsa);
            try (ResultSet lista_resultados = comando.executeQuery()) {
                while (lista_resultados.next()) {
                    Possuir possuir = new Possuir(
                            lista_resultados.getInt("Sequencial"),
                            Bolsa.buscarBolsa(lista_resultados.getInt("bolsaId")),
                            Item.buscarItem(lista_resultados.getString("itemId"))
                    );
                    possuis.add(possuir);
                }
            }
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return new Possuir[0];
        }

        return possuis.toArray(new Possuir[0]);
    }
      
     
     public static Item[] buscarItensBolsa (int sequencial_bolsa) {
        String sql = "SELECT Sequencial, ItemId FROM Possuir WHERE BolsaId = ?";
        ResultSet lista_resultados = null;
        ArrayList<Item> visões = new ArrayList();
        try {
        PreparedStatement comando = BD.conexão.prepareStatement(sql);
        comando.setInt(1, sequencial_bolsa);
        lista_resultados = comando.executeQuery();
        while (lista_resultados.next()) {
        visões.add(Item.buscarItem(lista_resultados.getString("ItemId")));
        }
        lista_resultados.close();
        comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões.toArray(new Item[visões.size()]);
    }
     
     public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public Item getItem() {
        return item;
    }

    public String toString() {
        return item.getNome() + " [" + item.getPeso() + "]";
    }
}
