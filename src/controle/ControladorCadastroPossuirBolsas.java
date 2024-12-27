package controle;


import entidade.Possuir;
import interfaces.JanelaCadastrarPossuir;
import interfaces.JanelaCadastrarBolsas;

public class ControladorCadastroPossuirBolsas {
    
    public ControladorCadastroPossuirBolsas(
            JanelaCadastrarBolsas janela_cadastro_possuir, int sequencial_bolsa) {
        new JanelaCadastrarPossuir(this,
                janela_cadastro_possuir, sequencial_bolsa).setVisible(true);
    }

    public String removerPossuir(int sequencial) {
        boolean existe_possuir = Possuir.existePossuir(sequencial);
        if (existe_possuir) {
            return Possuir.removerPossuir(sequencial);
        } else {
            return "Posse não cadastrada";
        }
    }

    public String inserirPossuir(Possuir possuir) {
        boolean existe_possuir = Possuir.existePossuir(possuir.getBolsa().getSequencial(),
                possuir.getItem().getNome());
        if (!existe_possuir) {
            return Possuir.inserirPossuir(possuir);
        } else {
            return "Sequencial de posse já cadastrado";
        }
    }
}
