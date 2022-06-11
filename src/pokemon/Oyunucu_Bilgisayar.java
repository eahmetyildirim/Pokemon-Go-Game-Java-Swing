/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ahmet Yıldırım
 */
public class Oyunucu_Bilgisayar extends Oyuncu{
  
    
    public Oyunucu_Bilgisayar() {
    }

    public Oyunucu_Bilgisayar(int oyuncuID, String oyunucuAdi, int skor) {
        super(oyuncuID, oyunucuAdi, skor);
    }

    @Override
    public int kartAl(ArrayList<Pokemon> eldeki_kart) {
       Random random=new Random();
       int rast_i=random.nextInt(eldeki_kart.size());

    
       
       return rast_i;
    }
    
    
    
    @Override
    public int kartSec() {
        Random random=new Random();
        int secilen_id=random.nextInt(getKart_list().size());
        
        return secilen_id;
    }

  
    
    
}
