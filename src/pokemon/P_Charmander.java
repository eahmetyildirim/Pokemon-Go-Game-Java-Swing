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
public class P_Charmander extends Pokemon{
    private int hasar_puani;

    public P_Charmander() {
           super( "Charmander", "Ateş","charmander.png");

        this.hasar_puani=60;
    }

    public P_Charmander(int pokemon_ID) {
        super(pokemon_ID, "Charmander", "Ateş","charmander.png");
              this.hasar_puani=60;
    }

    @Override
   public int hasar_PuaniGoster() {
        return hasar_puani;
    }  
    
    
}
