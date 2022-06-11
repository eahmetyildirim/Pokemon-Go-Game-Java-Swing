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
public class P_Butterfree extends Pokemon{
     private int hasar_puani;

    public P_Butterfree() {
        super("Butterfree", "Hava","butterfree.png");
        this.hasar_puani=10;
    }
    
    public P_Butterfree(int pokemon_ID) {
        super(pokemon_ID, "Butterfree", "Hava","butterfree.png");
        this.hasar_puani=10;
    }
    
     
    @Override
   public int hasar_PuaniGoster() {
        return hasar_puani;
    }  
}
