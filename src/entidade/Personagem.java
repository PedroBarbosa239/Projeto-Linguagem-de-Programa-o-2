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

import entidade.SerMágico.HabilidadeMágica;
import entidade.SerMágicoRaçaInteligente.Tendência;




public class Personagem {
    
    public enum Classe {Barbaro,Guerreiro,Mago,Monge, Sarcedote};
    
    private String nome;
    private int sequencial, nivel, pontos_vida, pontos_forca;
    private Classe classe;
    private Bolsa bolsa;
    private SerMágico serMágico;
    
    public Personagem(int sequencial, String nome, int nivel, int pontos_vida, int pontos_forca, Classe classe) {
        this.sequencial = sequencial;
        this.nome = nome;
        this.nivel = nivel;
        this.pontos_vida = pontos_vida;
        this.pontos_forca = pontos_forca;
        this.classe = classe;   
    }
    
public Personagem(int sequencial, Bolsa bolsa, SerMágico serMágico, int nivel) {
    this.sequencial = sequencial;
    this.bolsa = bolsa;
    this.serMágico = serMágico;
    this.nivel= nivel;

}

public Personagem(int sequencial, String nome, int nivel, int pontos_vida, int pontos_forca, 
        Classe classe, Bolsa bolsa, SerMágico serMágico) {
    this.nome = nome; 
    this.nivel = nivel;
    this.pontos_vida = pontos_vida; 
    this.pontos_forca = pontos_forca;
    this.classe = classe; 
    this.bolsa = bolsa; 
    this.serMágico = serMágico; 
}

public Personagem(int sequencial, String nome, int nivel) {
    this.sequencial = sequencial;
    this.nome = nome; 
    this.nivel = nivel;

}
    
    public String toString() {
         return "["+sequencial+ "] LV: " + nivel + " - Bolsa: " + bolsa.getVisão() + " | Ser Mágico: " + serMágico.getVisão();
    }
    
   public String toStringFull() {
      String str = "[" + nome + "] Nivel: " + nivel
                + " --- Ser "+ serMágico.toStringFull()
                + " -- Bolsa: " + bolsa.toStringFull() + "\n    Itens:";
      
        Item[] itens_bolsa = Possuir.buscarItensBolsa(bolsa.getSequencial());
        for (Item item : itens_bolsa) {
            str += item.toStringFull();
        }
        return str;
    }
    
    public Personagem getVisão() { 
        return new Personagem(sequencial,nome,nivel); 
    }
    
    public int getSequencial(){
        return sequencial;
    }
    
   public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    public int getPontosVida(){
        return pontos_vida;
    }
    
    public int getPontosForça(){
        return pontos_forca;
    }
    
    public Classe getClasse(){
        return classe;
    }
    
      public Bolsa getBolsa(){
        return bolsa;
    }
      
      
        public SerMágico getSerMagico(){
        return serMágico;
    }
      
      
    
    public static Personagem[] getVisões () {
        String sql = "SELECT Sequencial, BolsaId, SerMágicoId,Nivel FROM Personagens";
        ResultSet lista_resultados = null;
        ArrayList<Personagem> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Personagem (lista_resultados.getInt("Sequencial"),
                Bolsa.buscarBolsa(lista_resultados.getInt("BolsaId")).getVisão(),
                SerMágico.buscarSerMágico(lista_resultados.getString("SerMágicoId")).getVisão(),
                lista_resultados.getInt("Nivel")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões.toArray(new Personagem[visões.size()]);
    }
    
    public static boolean existePersonagem (int chave_bolsa, String chave_ser) {
        String sql = "SELECT Sequencial FROM Personagens WHERE BolsaId = ? AND SerMágicoId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, chave_bolsa);
            comando.setString(2, chave_ser);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
        exceção_sql.printStackTrace ();
        }
        return existe;
    }
    
    public static String inserirPersonagem (Personagem personagem) {
        String sql = "INSERT INTO Personagens (BolsaId, SerMágicoId, Nome,"
        + " Nivel, Pontos_vida, Pontos_força, Classe)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, personagem.getBolsa().getSequencial());
            comando.setString(2, personagem.getSerMagico().getNome());
            comando.setString(3, personagem.getNome());
            comando.setInt(4, personagem.getNivel());
            comando.setInt(5, personagem.getPontosVida());
            comando.setInt(6, personagem.getPontosForça());
            comando.setInt(7, personagem.getClasse().ordinal());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Inserção da Personagem no BD";
        }
    }
    
    public static String alterarPersonagem (Personagem personagem) {
        String sql = "UPDATE Personagens SET Nivel = ?, Pontos_vida = ?, Pontos_força = ?, Classe = ?, BolsaId = ?, SerMágicoID = ? WHERE Sequencial = ?";
        System.out.println("Nivel: " + personagem.getNivel());
        System.out.println("Pontos de vida: " + personagem.getPontosVida());
        System.out.println("Pontos de força: " + personagem.getPontosForça());
        System.out.println("Classe: " + personagem.getClasse());
        System.out.println("Sequencial: " + personagem.getSequencial());

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, personagem.getNivel());
            comando.setInt(2, personagem.getPontosVida());
            comando.setInt(3, personagem.getPontosForça());
            comando.setInt(4, personagem.getClasse().ordinal());
            comando.setInt(5, personagem.bolsa.getSequencial());
            comando.setString(6, personagem.serMágico.getNome());
            comando.setInt(7, personagem.getSequencial());
  
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Alteração da Personagem no BD";
            }
    }
    
    public static Personagem buscarPersonagem (int sequencial) {
        String sql = "SELECT * FROM Personagens where Sequencial = ?";
        ResultSet lista_resultados = null;
        Personagem personagem = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                    personagem = new Personagem (
                        sequencial,
                        lista_resultados.getString("Nome"),
                        lista_resultados.getInt("Nivel"),
                        lista_resultados.getInt("Pontos_vida"),
                        lista_resultados.getInt("Pontos_força"),
                        Classe.values()[lista_resultados.getInt("Classe")],       
                        Bolsa.buscarBolsa(lista_resultados.getInt("BolsaId")),
                        SerMágico.buscarSerMágico(lista_resultados.getString("SerMágicoId"))
                    );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
        exceção_sql.printStackTrace ();
        personagem = null;
        }
        return personagem;
    }
    
    public static boolean existePersonagem (int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM Personagens WHERE Sequencial = ?";
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
             exceção_sql.printStackTrace ();
        }
        return existe;
    }
    
        public static String removerPersonagem (int sequencial) {
        String sql = "DELETE FROM Personagens WHERE Sequencial = ?";
        try {
        PreparedStatement comando = BD.conexão.prepareStatement(sql);
        comando.setInt(1, sequencial);
        comando.executeUpdate();
        comando.close();
        return null;
        } catch (SQLException exceção_sql) {
        exceção_sql.printStackTrace ();
        return "Erro na Remoção de Personagem no BD";
        }
    }
        
        
    public static int últimoSequencial() {
        String sql = "SELECT MAX(sequencial) FROM Personagens";
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
    
    public static ArrayList<Personagem> pesquisarPersonagens
        (int nivel_personagem, int peso_item, HabilidadeMágica habilidade_ser, 
        char hostil_monstro, Tendência tendencia_rac, Boolean todos_itens_bolsa,int peso_bolsa) {
            String sql = "SELECT Per.Sequencial, Per.Nivel, Ser.nome, Ser.HabilidadeMagica, Bol.Sequencial, Bol.Peso_Max"
           + " FROM Personagens Per, Bolsas Bol, SeresMagicos Ser"
           + " WHERE Per.BolsaId = Bol.Sequencial AND Per.SerMágicoId = Ser.Nome";

            if (nivel_personagem > -1) sql += " AND Per.Nivel <= ?";
            if (peso_bolsa > -1) sql += " AND Bol.Peso_Max <= ?";
            if (habilidade_ser != null) sql += " AND Ser.HabilidadeMagica = ?";
            sql += " ORDER BY Per.Sequencial";
            
            ResultSet lista_resultados = null;
            ArrayList<Personagem> personagens_selecionadas = new ArrayList();
            int index = 0;
            int sequencial_bolsa = -1;
            String chave_ser = null;
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                if (nivel_personagem > 0) comando.setInt(++index, nivel_personagem);
                if (peso_bolsa > 0) comando.setInt(++index, peso_bolsa);
                if (habilidade_ser != null) comando.setInt(++index, habilidade_ser.ordinal());
                lista_resultados = comando.executeQuery();

                while (lista_resultados.next()) {
                    Personagem personagem_pesquisada = Personagem.buscarPersonagem(lista_resultados.getInt(1));
                    chave_ser = lista_resultados.getString(3);
                    sequencial_bolsa = lista_resultados.getInt(5);
         
                    if (!itensAtendemFiltros(sequencial_bolsa, peso_item, todos_itens_bolsa)) {
                    continue;
                    }
                    if (hostil_monstro != 'X') {
                        if (isOkPesquisaEmSerMágicoMonstro(chave_ser, hostil_monstro))
                            personagens_selecionadas.add(personagem_pesquisada);
                    } else if (tendencia_rac != null) {
                        if (isOkPesquisaEmSerMágicoRaça(chave_ser, tendencia_rac))
                            personagens_selecionadas.add(personagem_pesquisada);
                    } else personagens_selecionadas.add(personagem_pesquisada);
                }
                lista_resultados.close();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
            }
            return personagens_selecionadas;
    }
    
        private static boolean itensAtendemFiltros(int sequencial_bolsa, int peso_item, Boolean todos_itens_bolsa){
                Item[] itens_bolsa = Possuir.buscarItensBolsa(sequencial_bolsa);
                int total_itens_não_atendem_filtros = 0;
                for (Item item : itens_bolsa) {
                    if (((peso_item != -1) && (item.getPeso() >= peso_item))) {
                        total_itens_não_atendem_filtros++;
                    if (todos_itens_bolsa) return false;
                    }
                }
                if (total_itens_não_atendem_filtros == 0) return true;
                if ((todos_itens_bolsa) || (total_itens_não_atendem_filtros == itens_bolsa.length))return false;
                return true;
        }
        
        
     private static boolean isOkPesquisaEmSerMágicoMonstro(String chave_ser, char hostil_monstro) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM SeresMagicosMonstros WHERE SerMágicoId = ?";
        if (hostil_monstro != 'X') {
            sql += " AND Hostil = ?";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_ser);
            
           switch(hostil_monstro) {
                case 'T': comando.setBoolean(++index, true); break;
                case 'F': comando.setBoolean(++index, false);
            }
            
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return pesquisa_ok;
    }
    
        private static boolean isOkPesquisaEmSerMágicoRaça(String chave_ser,Tendência tendencia) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM SeresMagicosRacasInteligente WHERE SerMágicoId = ?";
        if (tendencia != null) {
            sql += " AND Tendência = ?";
        }
        ResultSet lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_ser);
            if (tendencia != null) {
                comando.setInt(2, tendencia.ordinal());
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next())
                pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return pesquisa_ok;
    }
}
