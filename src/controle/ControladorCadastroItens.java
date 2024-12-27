
package controle;

import entidade.Item;
import interfaces.JanelaCadastrarItens;

public class ControladorCadastroItens {
    
    public ControladorCadastroItens(){
        new JanelaCadastrarItens(this).setVisible(true);
    }
    
    
    public String inserirItem (Item item) {
        Item item1 = Item.buscarItem(item.getNome());
        if (item1 == null) return Item.inserirItem(item);
        else return "Nome de item já cadastrado";
    }
    
    public String alterarItem(Item item) {
        Item item1 = Item.buscarItem(item.getNome());
        if (item1 != null) return Item.alterarItem(item);
        else return "Nome de item não cadastrado";
    }
    
    public String removerItem (String nome) {
        Item item1 = Item.buscarItem(nome);
        if (item1 != null) return Item.removerItem(nome);
        else return "Nome de item não cadastrado";
    }
}
   