/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.ArrayList;

/**
 *
 * @author Ahmet Yıldırım
 */
public class Oyunucu_Insan extends Oyuncu{
   

    public Oyunucu_Insan() {
    }

    public Oyunucu_Insan(int oyuncuID, String oyunucuAdi, int skor) {
        super(oyuncuID, oyunucuAdi, skor);
    }
    
    
    @Override
    public int kartSec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
