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
public class P_Bulbasaur extends Pokemon{
    private int hasar_puani;

    public P_Bulbasaur() {
        super("Bulbasur","Çim","bulbasaur.png");     
        hasar_puani=50;
    }
    
    public P_Bulbasaur(int pokemon_ID) {
        super(pokemon_ID, "Bulbasur","Çim","bulbasaur.png");
         hasar_puani=50;
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
