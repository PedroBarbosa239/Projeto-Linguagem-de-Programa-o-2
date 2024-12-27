package controle;
import entidade.Bolsa;
import interfaces.JanelaCadastrarBolsas;

public class ControladorCadastroBolsas {
   
    public ControladorCadastroBolsas(){
         System.out.println("Ele entra aqui");
        new JanelaCadastrarBolsas(this).setVisible(true);
    }
    
    public String inserirBolsa(Bolsa bolsa) {
        if (!Bolsa.existeBolsaMesmosAtributos(bolsa)) {
            return Bolsa.inserirBolsa(bolsa);
        } else {
            return "Já existe uma bolsa com os mesmos atributos";
        }
    }

    public String alterarBolsa(Bolsa bolsa) {
        Bolsa bolsa1 = Bolsa.buscarBolsa(bolsa.getSequencial());
        if (bolsa1 != null) {
            return Bolsa.alterarBolsa(bolsa);
        } else {
            return "Bolsa não cadastrada";}
    }

    public String removerBolsa(int sequencial) {
        Bolsa bolsa1 = Bolsa.buscarBolsa(sequencial);
        if (bolsa1 != null) {
            return Bolsa.removerBolsa(sequencial);
        } else {
            return "bolsa não cadastrado";
        }
    }
}
