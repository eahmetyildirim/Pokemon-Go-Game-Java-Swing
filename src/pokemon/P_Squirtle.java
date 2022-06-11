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
public class P_Squirtle extends Pokemon{
    private int hasar_puani;

    public P_Squirtle() {
             super( "Squirtle", "Su","squirtle.png");
            this.hasar_puani=30;
    }
    
    public P_Squirtle(int pokemon_ID) {
        super(pokemon_ID, "Squirtle", "Su","squirtle.png");
        this.hasar_puani=30;
    }
    
     @Override
    public int hasar_PuaniGoster() {
        return hasar_puani;
    } 
}
