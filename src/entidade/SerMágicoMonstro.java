
package entidade;

public class SerMágicoMonstro extends SerMágico{
    private boolean hostil; 
    private int dano_adicional;
    
    public SerMágicoMonstro(String nome, HabilidadeMágica habilidade_mágica, boolean hostil, int dano_adicional) {
        super(nome, habilidade_mágica);
        this.hostil = hostil;
        this.dano_adicional = dano_adicional;
    }
    
    public SerMágicoMonstro getVisão () {
           return new SerMágicoMonstro (nome, habilidade_mágica, hostil, dano_adicional);
    }
    
    public String toString() {
        String str = "[" + nome + "] " + habilidade_mágica;
        if (hostil) str += " - Monstro hostil:"  ;
        else str += " - Monstro não hostil:"  ;
        return str;
    }
    
    public String toStringFull() {
        String str = super.toStringFull() + " " ;
         if (hostil) str += " - Monstro hostil:"  ;
        else str += " - Monstro não hostil:" ; str += " - " + dano_adicional + " Damege" ;
        return str;
    }
        
        public Boolean getHostil(){
        return hostil;
    }
        
       public void setHostilMonstro(boolean hostil) {
        this.hostil = hostil;
    }
       public int getDanoAdicional(){
        return dano_adicional;
    }
       
       
    
    
}
