package pokemon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;


public class Pokemon {
private int pokemon_ID;
private String pokemon_Adi;
private String pokemın_Tip;
private String icon_url;
public BufferedImage image;
    public Pokemon() {
    }

    public Pokemon(String pokemon_Adi, String pokemın_Tip,String url) {
    try {
        this.pokemon_Adi = pokemon_Adi;
        this.pokemın_Tip = pokemın_Tip;
        
        image = ImageIO.read(new FileImageInputStream(new File(url)));
    } catch (IOException ex) {
        Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public Pokemon(int pokemon_ID, String pokemon_Adi, String pokemın_Tip,String url) {
        this.pokemon_ID = pokemon_ID;
        this.pokemon_Adi = pokemon_Adi;
        this.pokemın_Tip = pokemın_Tip;
        
    try {
        image = ImageIO.read(new FileImageInputStream(new File(url)));
    } catch (IOException ex) {
        Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getPokemon_ID() {
        return pokemon_ID;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public void setPokemon_ID(int pokemon_ID) {
        this.pokemon_ID = pokemon_ID;
    }

    public String getPokemon_Adi() {
        return pokemon_Adi;
    }

    public void setPokemon_Adi(String pokemon_Adi) {
        this.pokemon_Adi = pokemon_Adi;
    }

    public String getPokemın_Tip() {
        return pokemın_Tip;
    }

    public void setPokemın_Tip(String pokemın_Tip) {
        this.pokemın_Tip = pokemın_Tip;
    }

    public int hasar_PuaniGoster(){ 
    return 0;
    }
    
}
