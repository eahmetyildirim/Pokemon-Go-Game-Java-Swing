
package pokemon;

import java.util.ArrayList;


public abstract class Oyuncu {
    private int oyuncuID;
    private String oyunucuAdi;
    private int skor;
    ArrayList<Pokemon> kart_list=new ArrayList<>();
    public Oyuncu() {
    }

    public Oyuncu(int oyuncuID, String oyunucuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyunucuAdi = oyunucuAdi;
        this.skor = skor;
    }
    
    public int getOyuncuID() {
        return oyuncuID;
    }

    public ArrayList<Pokemon> getKart_list() {
        return kart_list;
    }

    public void setKart_list(ArrayList<Pokemon> kart_list) {
        this.kart_list = kart_list;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyunucuAdi() {
        return oyunucuAdi;
    }

    public void setOyunucuAdi(String oyunucuAdi) {
        this.oyunucuAdi = oyunucuAdi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
 
    public void skorGoster(){
        System.out.println(skor);
    }
    public int kartAl(ArrayList<Pokemon> eldeki_kart){
    
    return 0;
    }
    public void  secilen_karti_sil(int i){
        kart_list.remove(i);
    }
    public abstract int kartSec();
}
