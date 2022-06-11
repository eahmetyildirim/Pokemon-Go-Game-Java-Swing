package pokemon;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class pcpc extends JFrame implements ActionListener{
    private ArrayList<Pokemon> kartlar;
    private OYUN oyun =new OYUN();
    private ArrayList<JButton> butonlar =new ArrayList<>();
    private ArrayList<JButton> oyuncu1_Buton =new ArrayList<>();
    private ArrayList<JButton> oyuncu2_Buton =new ArrayList<>();
    private ArrayList<Oyuncu> oyuncular=new ArrayList<>();
    private JButton kart_al,kart_at;
    private int oyun_tipi;
    private ArrayList<Integer> secilen_butonID=new ArrayList<>();
    private ArrayList<JButton> secilen_kart;
    Timer timer=new Timer(500, this);
    private int onceki_secili_buton=-1;
      private int onceki_secili_buton2=-1;
    public pcpc(int Oyun_Tipi) {
        timer.start();
        this.oyun_tipi=Oyun_Tipi;
        setSize(1600,950);      
        oyun.karistir();
        kartlar=oyun.getKartlar();
        
        if(oyun_tipi==1){
        oyuncular.add(new Oyunucu_Bilgisayar(1, "Bilgisayar-1",0));
        oyuncular.add(new Oyunucu_Bilgisayar(2, "Bilgisayar-2",0));
        oyuncular.get(0).setKart_list(oyun.uc_kart_sec());
        oyuncular.get(1).setKart_list(oyun.uc_kart_sec());
        }else if(oyun_tipi==2){
        oyuncular.add(new Oyunucu_Bilgisayar(1, "Bilgisayar",0));
        oyuncular.add(new Oyunucu_Insan(2, "Kullanıcı",0));
        }
       
        
       
        if(oyun_tipi==1){
        kart_al=new JButton("Kart Al");
        kart_at =new JButton("Kart At");
        kart_al.setBounds(1400, 600, 100, 50);
        kart_at.setBounds(1250, 600, 100, 50);
        add(kart_al);
        add(kart_at);
        }
        
       
        kartlari_Ekrana_yaz();
        setLayout(null);  
        if(oyun_tipi==1){
        kart_al.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(kartlar.size()>0 && oyuncular.get(0).getKart_list().size()<3){
                       
                        int secilen1_id=oyuncular.get(0).kartAl(kartlar);
                        oyuncular.get(0).getKart_list().add(kartlar.get(secilen1_id));
                        oyuncu1_Buton.add(butonlar.get(secilen1_id));
                      
                       butonlar.remove(secilen1_id);
                        kartlar.remove(secilen1_id);  
                        
                        int secilen2_id=oyuncular.get(1).kartAl(kartlar);
                        oyuncular.get(1).getKart_list().add(kartlar.get(secilen2_id));
                        oyuncu2_Buton.add(butonlar.get(secilen2_id));
                     
                       butonlar.remove(secilen2_id);
                        kartlar.remove(secilen2_id);
                       kartlari_ekranda_guncelle();
                      
                        }
                    }
                });
                kart_at.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(secilen_kart!=null){
                        secilen_kart.get(0).setVisible(false);
                        secilen_kart.get(1).setVisible(false);
                        }
                        
                        if(kartlar.size() >0 && oyuncular.get(0).getKart_list().size()==3){
                       kartSecimi();
                        }else if(kartlar.size()==0 && oyuncular.get(0).getKart_list().size()!=0 ){
                        kartSecimi();
                        }
                        
                      
                       
                    }
                });
            }else if(oyun_tipi==2){
               
                for(int i=0;i<butonlar.size();i++){
                    
                     
                    JButton buton=butonlar.get(i);
                    buton.setName(Integer.toString(i));
                    buton.addActionListener(new ActionListener() {
                        
                        @Override
                        public void actionPerformed(ActionEvent e) {
                         if(kartlar.size()>4){
                             
                             int id_kaymasi=0;
                              int kullanici_secilen_id=Integer.parseInt(buton.getName());
                              secilen_butonID.add(kullanici_secilen_id);
                            
                              for(int i:secilen_butonID){
                                  if(i<kullanici_secilen_id){
                                  id_kaymasi++;
                                  }
                                  
                             } 
                             kullanici_secilen_id-=id_kaymasi;
                            System.out.println(kartlar.get(kullanici_secilen_id).getPokemon_Adi());
                           /* if(kullanici_secilen_id< kartlar.size()-1){
                            System.out.println(kartlar.get(kullanici_secilen_id).getPokemon_Adi());
                            }else{
                              
                            
                            }*/
                           
                             
                        oyuncular.get(1).getKart_list().add(kartlar.get(kullanici_secilen_id));
                   
                        oyuncu2_Buton.add(butonlar.get(kullanici_secilen_id));
                       
                       butonlar.remove(kullanici_secilen_id);
                        kartlar.remove(kullanici_secilen_id);  
                        
                        int secilen2_id=oyuncular.get(0).kartAl(kartlar);
                        secilen_butonID.add(secilen2_id);
                        oyuncular.get(0).getKart_list().add(kartlar.get(secilen2_id));
                        oyuncu1_Buton.add(butonlar.get(secilen2_id));
                     
                      
                        butonlar.remove(secilen2_id);
                        kartlar.remove(secilen2_id);
                       kartlari_ekranda_guncelle();
                        }else{
                        
                         }
                         
                         }
                    });
                    
                    }
                
            }
        
        
        
     
    }
    
public void kartSecimi(){
    
         ArrayList<Pokemon> secilen_k=new ArrayList<>();
         secilen_kart=new ArrayList<>();
                            for(int i=0;i<2;i++){
                               int secilen_i;
                             
                               if(i==0){
                                secilen_i=oyuncular.get(i).kartSec();
                                secilen_k.add(oyuncular.get(i).getKart_list().get(secilen_i));
                                oyuncular.get(i).secilen_karti_sil(secilen_i);
                                secilen_kart.add(oyuncu1_Buton.get(secilen_i));
                                oyuncu1_Buton.get(secilen_i).setVisible(false);
                                oyuncu1_Buton.remove(secilen_i);
                               }
                               if(i==1){
                                secilen_i=oyuncular.get(i).kartSec();
                                secilen_k.add(oyuncular.get(i).getKart_list().get(secilen_i));
                                oyuncular.get(i).secilen_karti_sil(secilen_i);
                               
                                    secilen_kart.add(oyuncu2_Buton.get(secilen_i));
                                   oyuncu2_Buton.get(secilen_i).setVisible(false);
                                   oyuncu2_Buton.remove(secilen_i);
                               }
                           }
                        
                            if(secilen_k.get(0).hasar_PuaniGoster()>secilen_k.get(1).hasar_PuaniGoster()){
                                    oyuncular.get(0).setSkor(oyuncular.get(0).getSkor()+5);
                            }else{
                                    oyuncular.get(1).setSkor(oyuncular.get(1).getSkor()+5);
                            }
                        
                            System.out.println("1.oyuncu skoru:"+oyuncular.get(0).getSkor());
                            System.out.println("2.oyuncu skoru:"+oyuncular.get(1).getSkor());
                            
                            secilen_kart.get(0).setBounds(850, 180, 170,220);
                            secilen_kart.get(1).setBounds(850, 450, 170,220);
                            secilen_kart.get(0).setVisible(true);
                            secilen_kart.get(1).setVisible(true);
                            add(secilen_kart.get(0));
                            add(secilen_kart.get(1));
                           
                          
    }
    public void kartSecimi(int secilenKart_i){
        System.out.println("Girdim");
         ArrayList<Pokemon> secilen_k=new ArrayList<>();
         secilen_kart=new ArrayList<>();
                    
                              
                     
                               int secilen_i=oyuncular.get(0).kartSec();
                                secilen_k.add(oyuncular.get(0).getKart_list().get(secilen_i));
                                oyuncular.get(0).secilen_karti_sil(secilen_i);
                                secilen_kart.add(oyuncu1_Buton.get(secilen_i));
                            //    oyuncu1_Buton.get(secilen_i).setVisible(false);
                                oyuncu1_Buton.remove(secilen_i);
                          
                       
                                
                                secilen_k.add(oyuncular.get(1).getKart_list().get(secilenKart_i));
                                oyuncular.get(1).secilen_karti_sil(secilenKart_i);
                               
                                    secilen_kart.add(oyuncu2_Buton.get(secilenKart_i));
                              //     oyuncu2_Buton.get(secilenKart_i).setVisible(false);
                                   oyuncu2_Buton.remove(secilenKart_i);
                             
                        
                        
                            if(secilen_k.get(0).hasar_PuaniGoster()>secilen_k.get(1).hasar_PuaniGoster()){
                                    oyuncular.get(0).setSkor(oyuncular.get(0).getSkor()+5);
                            }else{
                                    oyuncular.get(1).setSkor(oyuncular.get(1).getSkor()+5);
                            }
                        
                            System.out.println("1.oyuncu skoru:"+oyuncular.get(0).getSkor());
                            System.out.println("2.oyuncu skoru:"+oyuncular.get(1).getSkor());
                            
                            secilen_kart.get(0).setBounds(850, 180, 170,220);
                            secilen_kart.get(1).setBounds(850, 450, 170,220);
                            secilen_kart.get(0).setVisible(true);
                            secilen_kart.get(1).setVisible(true);
                            add(secilen_kart.get(0));
                            add(secilen_kart.get(1));
                            kartlari_ekranda_guncelle();
                          
    }
    public void kartlari_ekranda_guncelle(){
            for(int i=0;i<oyuncu1_Buton.size();i++){
            oyuncu1_Buton.get(i).setBounds(150+i*180, 80,170,220);
             
            add(oyuncu1_Buton.get(i));
        }
        
        for(int i=0;i<oyuncu2_Buton.size();i++){
            oyuncu2_Buton.get(i).setBounds(150+i*180, 600,170,220);
             
            add(oyuncu2_Buton.get(i));
        }
        
           int j=0,k=0,asagi_in,x_noktasi,y_noktasi;
        if(butonlar.size()>4){
            x_noktasi=600;
            y_noktasi=100;
        }else{
            x_noktasi=1200;
            y_noktasi=0;
        }
       
        asagi_in=butonlar.size()/2-1;
        for(int i=0;i<butonlar.size();i++){
            butonlar.get(i).setBounds(x_noktasi+k*180,y_noktasi+ 80+230*j,170,220);
                k++;
            if(i==asagi_in){
            j++;
            k=0;
            }
        
            add(butonlar.get(i));
        }
    
    }
    public void kartlari_Ekrana_yaz(){
        
        for(Pokemon i:oyuncular.get(0).getKart_list()){
             oyuncu1_Buton.add(new JButton(new ImageIcon(i.getImage()))); 
        }
        for(Pokemon i:oyuncular.get(1).getKart_list()){
             oyuncu2_Buton.add(new JButton(new ImageIcon(i.getImage()))); 
        }
        
        for(Pokemon i:kartlar){
             butonlar.add(new JButton(new ImageIcon(i.getImage()))); 
        }
        for(int i=0;i<oyuncu1_Buton.size();i++){
            oyuncu1_Buton.get(i).setBounds(150+i*180, 80,170,220);
             
            add(oyuncu1_Buton.get(i));
        }
        
        for(int i=0;i<oyuncu2_Buton.size();i++){
            oyuncu2_Buton.get(i).setBounds(150+i*180, 600,170,220);
             
            add(oyuncu2_Buton.get(i));
        }
        
        
        int j=0,k=0,asagi_in,x_noktasi,y_noktasi;
        if(butonlar.size()!=4){
            x_noktasi=200;
            y_noktasi=100;
        }else{
            x_noktasi=1200;
            y_noktasi=0;
        }
        asagi_in=butonlar.size()/2-1;
        for(int i=0;i<butonlar.size();i++){
            butonlar.get(i).setBounds(x_noktasi+k*180,y_noktasi+ 80+230*j,170,220);
                k++;
            if(i==asagi_in){
            j++;
            k=0;
            }
        
            add(butonlar.get(i));
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(oyun_tipi==2){
          timer.stop();
          
            for(int i=0;i<oyuncu2_Buton.size();i++){
                    
                     
                    JButton buton=oyuncu2_Buton.get(i);
                    buton.setName(Integer.toString(i));
                    buton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(onceki_secili_buton!=Integer.valueOf(buton.getName())){
                            onceki_secili_buton=Integer.valueOf(buton.getName());
                            System.out.println("Buton"+buton.getName());
                         
                       int sec_i= Integer.valueOf(buton.getName());
                     //   kartSecimi(sec_i);
                        if(kartlar.size() >0 && oyuncular.get(0).getKart_list().size()==3){
                            if(secilen_kart!=null){
                        secilen_kart.get(0).setVisible(false);
                        secilen_kart.get(1).setVisible(false);
                        }
                       kartSecimi(sec_i);
                        }else if(kartlar.size()==0 && oyuncular.get(0).getKart_list().size()!=0 ){
                            if(secilen_kart!=null){
                        secilen_kart.get(0).setVisible(false);
                        secilen_kart.get(1).setVisible(false);
                        }
                        kartSecimi(sec_i);
                        }
                                
                            }
                           
                        }
                    });
                    
                    
            }
            // KART AT SONU KART AL BAŞI
            if(kartlar.size()<=4){
            for(int i=0;i<butonlar.size();i++){
                    
                     
                    JButton buton=butonlar.get(i);
                    buton.setName(Integer.toString(i));
                    buton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(onceki_secili_buton2!=Integer.valueOf(buton.getName())){
                            onceki_secili_buton2=Integer.valueOf(buton.getName());
                            System.out.println("Buton"+buton.getName());
                         
                       int sec_i= Integer.valueOf(buton.getName());
                     //   kartSecimi(sec_i);
                        
                         if(kartlar.size()>0 && oyuncular.get(0).getKart_list().size()<3 ){
                       oyuncular.get(1).getKart_list().add(kartlar.get(sec_i));
                        oyuncu2_Buton.add(butonlar.get(sec_i));
                     
                       butonlar.remove(sec_i);
                        kartlar.remove(sec_i);
                        int secilen1_id=oyuncular.get(0).kartAl(kartlar);
                        oyuncular.get(0).getKart_list().add(kartlar.get(secilen1_id));
                        oyuncu1_Buton.add(butonlar.get(secilen1_id));
                      
                       butonlar.remove(secilen1_id);
                        kartlar.remove(secilen1_id);  
                        
                       
                        
                       kartlari_ekranda_guncelle();
                      
                        }
                     
                     
                                
                            }
                           
                        }
                    });
                    
                    
            }
            }
            
            onceki_secili_buton2=-1;
             timer.start();
        } 
                
    }
    
}
