/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class AStarSolmu {
    
    private int[] sijainti;
    private boolean suljettu;
    private int loppuun;
    private int alkuun;
    
    public AStarSolmu(){
        suljettu = false;
    }
    /**
     * Asettaa sijainnin
     * @param i rivin numero
     * @param j sarakkeen numero
     */
    public void setSijainti(int i, int j){
        sijainti = new int[2];
        sijainti[0] = i;
        sijainti[1] = j;
    }
    
    public int[] getSijainti(){
        return sijainti;
    }
    /**
     * Asettaa solmun suljetuksi.
     */
    public void asetaSuljetuksi(){
        suljettu = true;
    }
    
    public boolean onkoSuljettu(){
        return suljettu;
    }
    /**
     * Asettaa solmulle arvioidun etäisyyden kohdesolmuun.
     * @param matka 
     */
    public void setMatkaLoppuun(int matka){
        this.loppuun = matka;
    }
    /**
     * Asettaa solmulle arvioidun etäisyyden aloitussolmuun.
     * @param matka 
     */
    public void setMatkaAlkuun(int matka){
        this.alkuun = matka;
    }
    
    public void setTulosolmu(int i, int j){
        
    }
}
