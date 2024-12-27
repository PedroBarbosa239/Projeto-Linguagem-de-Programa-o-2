/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;
import entidade.SerMágico;
import entidade.SerMágico.HabilidadeMágica;



public class SerMágicoRaçaInteligente extends SerMágico{
    public enum Tendência {Caótico, Neutro, Bom};
    public enum Habitat {Montanha, Desfiladeiro, Savana, Deserto, Oceano, Floresta};
    
    private Tendência tendência; 
    private Habitat habitat;
    
    public SerMágicoRaçaInteligente(String nome, HabilidadeMágica habilidade_mágica, Tendência tendência, Habitat habitat) {
        super(nome, habilidade_mágica);
        this.tendência = tendência;
        this.habitat = habitat;
    }
    
    public SerMágicoRaçaInteligente getVisão () {
           return new SerMágicoRaçaInteligente(nome, habilidade_mágica, tendência, habitat);
    }
    
    public String toString() {
        String str = "[" + nome + "] " + habilidade_mágica;
        if (tendência != null) str += " - Tendência: "+tendência;
        return str;
    }
    
   public String toStringFull() {
            return " " + super.toStringFull() + " - Tendência: " + tendência+ "  ";                                                             
        
    }
    
       public Tendência getTendência(){
        return tendência;
    }
          public Habitat getHabitat(){
        return habitat;
    }
          
     public void setTendência(Tendência tendência) { 
         this.tendência = tendência; 
     }
     public void setHabitat(Habitat habitat) { 
         this.habitat = habitat; 
     }
    
}
