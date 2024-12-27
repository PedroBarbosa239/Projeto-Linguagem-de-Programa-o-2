
package controle;

import interfaces.JanelaCadastrarPersonagens;
import entidade.Personagem;

public class ControladorCadastroPersonagens {
    
        public ControladorCadastroPersonagens(){
            new JanelaCadastrarPersonagens(this).setVisible(true);
        }
        
        public String inserirPersonagem (Personagem personagem) {
            if (!Personagem.existePersonagem (personagem.getBolsa().getSequencial(),personagem.getSerMagico().getNome())) {
                return Personagem.inserirPersonagem (personagem);
            } else return "Personagem já cadastrado";
        }
        
        public String alterarPersonagem(Personagem personagem_informada) {
            Personagem personagens_cadastradas = Personagem.buscarPersonagem(personagem_informada.getSequencial() + 1);
            

            if ((personagem_informada.getSerMagico().getNome().equals(personagens_cadastradas.getSerMagico().getNome()))
            && (personagem_informada.getBolsa().getSequencial() == personagens_cadastradas.getBolsa().getSequencial())) {
            return Personagem.alterarPersonagem (personagem_informada);
            } else return "Alteração não permitida : chave do Ser e/ou da bolsa foram alteradas";
        }
        
        public String removerPersonagem (int sequencial) {
            if (Personagem.existePersonagem(sequencial)) return Personagem.removerPersonagem (sequencial);
            else return "Sequencial não corresponde a nenhuma reserva cadastrada";
        }
}
