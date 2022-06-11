
package pokemon;


public class P_Zubat extends Pokemon{
     private int hasar_puani;

    public P_Zubat() {
           super( "Zubat", "Hava","zubat.png");
             this.hasar_puani=50;
    }
    public P_Zubat(int pokemon_ID){
        super(pokemon_ID, "Zubat", "Hava","zubat.png");
        this.hasar_puani=50;
    }
    
    @Override
    public int hasar_PuaniGoster() {
        return hasar_puani;
    } 
}
