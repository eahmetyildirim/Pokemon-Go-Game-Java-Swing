/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author Ahmet Yıldırım
 */
public class P_Jigglypuff extends Pokemon{
     private int hasar_puani;
     
      public P_Jigglypuff() {
           super("Jigglypuff", "Ses","jıgglypuff.png");
            
             this.hasar_puani=70;
    }
    public P_Jigglypuff(int pokemon_ID) {
        super(pokemon_ID, "Jigglypuff", "Ses","jıgglypuff.png");
        this.hasar_puani=70;
    }
    
    @Override
    public int hasar_PuaniGoster() {
        return hasar_puani;
    } 
}
