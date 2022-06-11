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
public class P_Psyduck extends Pokemon{
       private int hasar_puani;

    public P_Psyduck() {
           super( "Psyduck","Su","psyduck.png");
        this.hasar_puani=20;
    }
     
    public P_Psyduck(int pokemon_ID) {
        super(pokemon_ID, "Psyduck","Su","psyduck.png");
        this.hasar_puani=20;
    }

    public int getHasar_puani() {
        return hasar_puani;
    }

    public void setHasar_puani(int hasar_puani) {
        this.hasar_puani = hasar_puani;
    }

    
    @Override
   public int hasar_PuaniGoster() {
        return hasar_puani;
    }  
}
