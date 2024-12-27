
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;
import entidade.SerMágicoRaçaInteligente.Habitat;
import entidade.SerMágicoRaçaInteligente.Tendência;



public class SerMágico {
 
    public enum HabilidadeMágica {Proeficiência, Fortalecimento, Sobrecarga, Voo};

    protected String nome; 
    protected HabilidadeMágica habilidade_mágica;
    
    public SerMágico(String nome, HabilidadeMágica habilidade_mágica){
        this.nome = nome;
        this.habilidade_mágica = habilidade_mágica;

    }
    public SerMágico(String nome){
        this.nome = nome;
    }
    
    public SerMágico getVisão() { 
        return new SerMágico (nome);
    }
    
    public static SerMágico[] getVisões() {
        System.out.println("vapo 2");
        String sql = "SELECT Nome, HabilidadeMagica FROM SeresMagicos";
        ResultSet lista_resultados = null;
        ArrayList<SerMágico> visões = new ArrayList();
         HabilidadeMágica habilidademágica = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                habilidademágica = HabilidadeMágica.values()[lista_resultados.getInt("HabilidadeMagica")];

                visões.add(new SerMágico(nome,habilidademágica));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
        }
        return visões.toArray(new SerMágico[visões.size()]);
        }
    
    public static SerMágico buscarSerMágico (String nome) {
        System.out.println("vapo 1");
        String sql = "SELECT * FROM SeresMagicos WHERE Nome = ?";
        ResultSet lista_resultados = null;
        HabilidadeMágica habilidademágica = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                nome = lista_resultados.getString("Nome");
                habilidademágica = HabilidadeMágica.values()[lista_resultados.getInt("HabilidadeMagica")];
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
        }
        if (nome == null) return null;
        
        sql = "SELECT Hostil, DanoAdicional FROM SeresMagicosMonstros " + " WHERE SerMágicoId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new SerMágicoMonstro (nome, habilidademágica,
                lista_resultados.getBoolean("Hostil"),
                lista_resultados.getInt("DanoAdicional"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace (); }
        sql = "SELECT Tendência, Habitat FROM SeresMagicosRacasInteligente" + " WHERE SerMágicoId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new SerMágicoRaçaInteligente (nome, habilidademágica,
                Tendência.values()[lista_resultados.getInt("Tendência")],
                Habitat.values()[lista_resultados.getInt("Habitat")]);
        }
        lista_resultados.close();
        comando.close();
        } catch (SQLException exceção_sql) { exceção_sql.printStackTrace (); }
        
        return null;
    }
    
    public static String inserirSerMágico(SerMágico ser_magico) {
        String sql = "INSERT INTO SeresMagicos (Nome, HabilidadeMagica) VALUES (?,?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, ser_magico.getNome());
            comando.setInt(2, ser_magico.getHabilidadeMagica().ordinal());

            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Inserção do Ser mágico no BD";
        }   
            String nome = últimoNome();
            if(ser_magico instanceof SerMágicoMonstro) {
            SerMágicoMonstro serMágico_monstro = (SerMágicoMonstro) ser_magico;
            sql = "INSERT INTO SeresMagicosMonstros"
            + " (Hostil, DanoAdicional,"
            + " SerMágicoId) VALUES (?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setBoolean(1, serMágico_monstro.getHostil());
                comando.setInt(2, serMágico_monstro.getDanoAdicional());
                comando.setString(3, nome);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Inserção do SerMágicoMonstro no BD";
            }
        } else if(ser_magico instanceof SerMágicoRaçaInteligente) {
            SerMágicoRaçaInteligente serMágico_raçaInteligente = (SerMágicoRaçaInteligente) ser_magico;
            sql = "INSERT INTO SeresMagicosRacasInteligente"
            + " (Tendência, Habitat,"
            + " SerMágicoId) VALUES (?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, serMágico_raçaInteligente.getTendência().ordinal());
                comando.setInt(2, serMágico_raçaInteligente.getHabitat().ordinal());
                comando.setString(3, nome);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Inserção do SerMágicoRaçaInteligente no BD";
              }
        }
        return null;
    }
    
    public static String alterarSerMágico (SerMágico ser_magico) {
        String sql = "UPDATE SeresMagicos SET HabilidadeMagica = ? WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, ser_magico.getHabilidadeMagica().ordinal());
            comando.setString(2, ser_magico.getNome());

            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Alteração do Ser mágico no BD";
        }
            if(ser_magico instanceof SerMágicoMonstro) {
            SerMágicoMonstro serMagico_monstro = (SerMágicoMonstro) ser_magico;
            sql = "UPDATE SeresMagicosMonstros"
            + " SET Hostil = ?, DanoAdicional = ?"
            + " WHERE SerMágicoId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setBoolean(1, serMagico_monstro.getHostil());
                comando.setInt(2, serMagico_monstro.getDanoAdicional());
                comando.setString(3, serMagico_monstro.getNome());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Inserção do SerMágicoMonstro no BD";
            }
        } else if(ser_magico instanceof SerMágicoRaçaInteligente) {
            SerMágicoRaçaInteligente serMagico_raça = (SerMágicoRaçaInteligente) ser_magico;
            sql = "UPDATE SeresMagicosRacasInteligente"
            + " SET Tendência = ?, Habitat = ?"
            + " WHERE SerMágicoId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, serMagico_raça.getTendência().ordinal());
                comando.setInt(2, serMagico_raça.getHabitat().ordinal());
                comando.setString(3, serMagico_raça.getNome());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Inserção do SerMágicoRaçaInteligente no BD";
            }
        }
        return null;
        
    }
    
    public static String removerSerMágico (SerMágico ser_mágico) {
        String nome = ser_mágico.getNome();
        if (ser_mágico instanceof SerMágicoMonstro) {
            String sql = "DELETE FROM SeresMagicosMonstros WHERE SerMágicoId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setString(1, nome);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Remoção do SerMágicoMonstro do BD";
            }
        } else if (ser_mágico instanceof SerMágicoRaçaInteligente) {
            String sql = "DELETE FROM SeresMagicosRacasInteligente WHERE SerMágicoId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setString(1, nome);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                return "Erro na Remoção do FilmeOriginal do BD";
            }
        }
        
        String sql = "DELETE FROM SeresMagicos WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Remoção do Ser mágico no BD";
        }
      
    }
    
     public static String últimoNome() {
        String sql = "SELECT MAX(Nome) FROM SeresMagicos";
        ResultSet lista_resultados = null;
        String nome = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                nome = lista_resultados.getString(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return nome;
    }

     
     
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public HabilidadeMágica getHabilidadeMagica(){
        return habilidade_mágica;
    }

    public String toString(){
        return "[" + nome + "] habilidade: " + habilidade_mágica + " - ";
    }
    
    public String toStringFull() {
        return "["+getNome()+"] Habilidade: " + habilidade_mágica;
    }
    
    
}
