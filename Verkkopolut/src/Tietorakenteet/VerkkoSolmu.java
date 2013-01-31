/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class Verkkosolmu {
    
    private int paino;
    private int[] sijainti;
    
    public Verkkosolmu(int paino){
        this.paino = paino;
    }
    /**
     * Asettaa Verkkosolmu-olion sijainnin matriisissa. Luo uuden taulukon, joka sisältää koordinaatit järjestyksessä [i, j];
     * @param i Rivin indeksi.
     * @param j Sarakkeen indeksi.
     */
    public void setSijainti(int i, int j){
        this.sijainti = new int[2];
        sijainti[0] = i;
        sijainti[1] = j;
    }
    
    public void setPaino(int paino){
        this.paino = paino;
    }
    
    public int[] getSijainti(){
        return sijainti;
    }
    
    public int getPaino(){
        return paino;
    }
}
