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


public class Bolsa {
    public enum Qualidade {Ruim, Regular, Bom, Ótimo, Prestigio, Lendário, Herói};
    
    private int sequencial, peso_max;
    private Qualidade qualidade;
    
    public Bolsa(int sequencial, int peso_max, Qualidade qualidade){
        this.sequencial = sequencial;
        this.peso_max = peso_max;
        this.qualidade = qualidade;

    }
    
        public Bolsa(int sequencial, int peso_max) {
        this.sequencial = sequencial;
        this.peso_max = peso_max;
    }
    
    public static int últimoSequencial() {
        String sql = "SELECT MAX(sequencial) FROM Bolsas";
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
    
    public static Bolsa[] getVisões() {
        String sql = "SELECT Sequencial, Peso_Max FROM Bolsas";
        ResultSet lista_resultados = null;
        ArrayList<Bolsa> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                    visões.add(new Bolsa(lista_resultados.getInt("Sequencial"), lista_resultados.getInt("Peso_Max")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Bolsa[visões.size()]);
    }
    
    
     public static Boolean existeBolsaMesmosAtributos(Bolsa bolsa) {
        String sql = "SELECT COUNT(Sequencial) FROM Bolsas WHERE Peso_Max = ? AND Qualidade = ?";
        ResultSet lista_resultados = null;
        int n_bolsas_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, bolsa.peso_max);
            comando.setString(2, bolsa.qualidade.toString());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_bolsas_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (n_bolsas_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }
     
      public static String inserirBolsa(Bolsa bolsa) {
        String sql = "INSERT INTO Bolsas (sequencial, Peso_Max, Qualidade) VALUES (?, ?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, bolsa.getSequencial());
            comando.setInt(2, bolsa.getPesoMax());
            comando.setInt(3, bolsa.getQualidade().ordinal());
            comando.execute();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na inserção da bolsa no BD";
        }
    }
    
        public static String alterarBolsa(Bolsa bolsa) {
        String sql = "UPDATE Bolsas SET Peso_Max = ?, Qualidade = ? WHERE sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, bolsa.getPesoMax());
            comando.setInt(2, bolsa.getQualidade().ordinal());
            comando.setInt(3, bolsa.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na alteração da Bolsa no BD";
        }
    }

        
        public static String removerBolsa(int sequencial) {
        String sqlDeletePossuir = "DELETE FROM Possuir WHERE BolsaId = ?";
        String sqlDeleteBolsa = "DELETE FROM Bolsas WHERE sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sqlDeletePossuir);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();

            comando = BD.conexão.prepareStatement(sqlDeleteBolsa);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();

            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na exclusão da bolsa e seus itens no BD";
        }
    }

        
         public static Bolsa buscarBolsa(int sequencial) {
        String sql = "SELECT * FROM Bolsas WHERE sequencial = ?";
        ResultSet lista_resultados = null;
        Bolsa bolsa = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                bolsa = new Bolsa(lista_resultados.getInt("sequencial"),
                        lista_resultados.getInt("Peso_Max"),
                        Qualidade.values()[lista_resultados.getInt("Qualidade")]);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            bolsa = null;
        }
        return bolsa;
    }
         
    public Bolsa getVisão() {
        return new Bolsa(sequencial, peso_max);
    }

    public String toString() {
        return "[" + getSequencial() + "] " + getPesoMax() + "Kg";
    }
    
    public String toStringFull() {
        return  "[" + sequencial + "] - peso Máximo: " + peso_max+ " Kg ";
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public int getPesoMax() {
        return peso_max;
    }
    
    public void setPesoMax(int peso_max) {
        this.peso_max = peso_max;
    }
    
    public Qualidade getQualidade(){
        return qualidade;
    }

    public void setNome(int peso_max) {
        this.peso_max = peso_max;
    }
    
}
