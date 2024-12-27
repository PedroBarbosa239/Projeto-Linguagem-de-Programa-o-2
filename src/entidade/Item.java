package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;



public class Item {
    private String nome;
    private int peso, valor, quantidade;
    private Boolean consumivel;

    
    public Item(String nome, int peso, int valor, int quantidade, Boolean consumivel) {
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
        this.quantidade = quantidade;
        this.consumivel = consumivel;   
    }
    
        public Item(String nome, int peso) {
        this.nome = nome;
        this.peso = peso;
    }
    
       public static Item[] getVisões() {
        String sql = "SELECT Nome, Peso FROM Itens";
        ResultSet lista_resultados = null;
        ArrayList<Item> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                int peso = lista_resultados.getInt("Peso");
                visões.add(new Item(nome,peso));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
        }
        return visões.toArray(new Item[visões.size()]);
        }
    
    public static Item buscarItem (String nome) {
        String sql = "SELECT * FROM Itens WHERE Nome = ?";
        ResultSet lista_resultados = null;
        Item item = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                item = new Item (lista_resultados.getString("nome"),
                lista_resultados.getInt("Valor"),
                lista_resultados.getInt("Peso"),
                lista_resultados.getInt("Quantidade"),
                lista_resultados.getBoolean("Consumivel"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            item = null;
        }
        return item;
    }
    
    public static String inserirItem(Item item) {
        String sql = "INSERT INTO Itens (Nome, Peso, Valor, Quantidade,Consumivel) VALUES (?,?,?,?,?)";
        try {
        PreparedStatement comando = BD.conexão.prepareStatement(sql);
        comando.setString(1, item.getNome());
        comando.setInt(2, item.getPeso());
        comando.setInt(3, item.getValor());
        comando.setInt(4, item.getQuantidade());
        comando.setBoolean(5, item.getConsumivel());
        comando.executeUpdate();
        comando.close();
        return null;
        } catch (SQLException exceção_sql) {
        exceção_sql.printStackTrace ();
        return "Erro na Inserção do Item no BD";
        }
    }
    
    public static String alterarItem (Item item) {
        String sql = "UPDATE Itens SET  Peso = ?, Valor = ?, Quantidade = ?, Consumivel = ? WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);

            comando.setInt(1, item.getPeso());
            comando.setInt(2, item.getValor());
            comando.setInt(3, item.getQuantidade());
            comando.setBoolean(4, item.getConsumivel());
            comando.setString(5, item.getNome());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na Alteração do Item no BD";
        }
    }
    
    public static String removerItem (String nome) {
        String sql = "DELETE FROM Itens WHERE Nome = ?";
        try {
        PreparedStatement comando = BD.conexão.prepareStatement(sql);
        comando.setString(1, nome);
        comando.executeUpdate();
        comando.close();
        return null;
        } catch (SQLException exceção_sql) {
        exceção_sql.printStackTrace ();
        return "Erro na Remoção do Item no BD";
        }
    }
    
    
     
    public String toString() {
         return "[" + getNome() + "] " + getPeso() + "Kg";
    }
       public String toStringFull() {
        return   " [" + nome + "] - Peso: " + peso  + " Kg  -";
    }
    
    public Item getVisão() { 
        return new Item(nome,peso); 
    }
    
     public String getNome(){
        return nome;
    }
      public int getPeso(){
        return peso;
    }
      
    public void setPeso(int peso){
        this.peso = peso;
    }
       public int getValor(){
        return valor;
    }
        public int getQuantidade(){
        return quantidade;
    }
        public Boolean getConsumivel(){
        return consumivel;
    }

}
