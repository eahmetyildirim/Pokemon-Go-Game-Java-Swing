

package pokemon;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;


public class OYUN{
    
    private ArrayList<Pokemon> kartlar;
    private Random random=new Random();
    private int secim;
    public OYUN(){
        kartlar=new ArrayList<>();
        kartlar.add(new P_Pikachu(1));
        kartlar.add(new P_Bulbasaur(2));
        kartlar.add(new P_Charmander(3));
        kartlar.add(new P_Squirtle(4));
        kartlar.add(new P_Zubat(5));
        kartlar.add(new P_Psyduck(6));
        kartlar.add(new P_Snorlax(7));
        kartlar.add(new P_Butterfree(8));
        kartlar.add(new P_Jigglypuff(9));
        kartlar.add(new P_Meowth(10));
    }
    
   
   public ArrayList<Pokemon> uc_kart_sec(){
       ArrayList<Pokemon> secilen=new ArrayList<>();
       for(int i=0;i<3;i++){
           int rast_i=random.nextInt(kartlar.size());
           secilen.add(kartlar.get(rast_i));
           kartlar.remove(rast_i);
           
       }
       
   return secilen;
   }
   public ArrayList<Pokemon> karistir(){
        ArrayList<Pokemon> liste=new ArrayList<>();
        int boyut=kartlar.size();
         for(int i=0;i<boyut;i++){
           
        int rastgele_i=random.nextInt(boyut-i);
        liste.add(kartlar.get(rastgele_i));
        kartlar.remove(rastgele_i);
        }
   kartlar=(ArrayList<Pokemon>) liste.clone();
   return liste;
   } 

    public ArrayList<Pokemon> getKartlar() {
        return kartlar;
    }

    public void setKartlar(ArrayList<Pokemon> kartlar) {
        this.kartlar = kartlar;
    }
    
    public static void main(String[] args) {
        OYUN X=new OYUN();
  
        ArrayList<Pokemon> kartlar=X.karistir();
        
        for(Pokemon i:kartlar){
            System.out.println(i.getPokemon_Adi());
        }
    }
    
}
