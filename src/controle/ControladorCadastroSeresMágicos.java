
package controle;
import entidade.SerMágico;
import interfaces.JanelaCadastrarSeresMágicos;

public class ControladorCadastroSeresMágicos {
   
    public ControladorCadastroSeresMágicos(){
        new JanelaCadastrarSeresMágicos(this).setVisible(true);
    }
    
    public String inserirSerMágico (SerMágico ser_mágico) {
        SerMágico ser_mágico1 = SerMágico.buscarSerMágico(ser_mágico.getNome());
        if (ser_mágico1 == null) return SerMágico.inserirSerMágico(ser_mágico);
        else return "Nome de ser mágico já cadastrado";
    }
    
    public String alterarSerMágico(SerMágico ser_mágico) {
        SerMágico ser_mágico1 = SerMágico.buscarSerMágico(ser_mágico.getNome());
        if (ser_mágico1 != null) return SerMágico.alterarSerMágico(ser_mágico);
        else return "Nome de ser mágico não cadastrado";
    }
    
    public String removerSerMágico (SerMágico ser_mágico) {
        SerMágico ser_mágico1 = SerMágico.buscarSerMágico(ser_mágico.getNome());
        if (ser_mágico1 != null) return SerMágico.removerSerMágico(ser_mágico1);
        else return "Nome de ser mágico não cadastrado";
    }
}

