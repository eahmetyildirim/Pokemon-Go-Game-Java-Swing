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
public class P_Meowth extends Pokemon{
     private int hasar_puani;

    public P_Meowth() {
         super( "Meowth", "Normal","meowth.png");
       
        this.hasar_puani=40;
    }

     
    public P_Meowth(int pokemon_ID) {
        super(pokemon_ID, "Meowth", "Normal","meowth.png");
        this.hasar_puani=40;
    }
    
    @Override
  public int hasar_PuaniGoster() {
        return hasar_puani;
    }  
}
