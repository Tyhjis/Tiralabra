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
    private int[] tulosolmu;
    private int matkaloppuun;
    private int matkaalkuun;
    
    public Verkkosolmu(int paino){
        this.paino = paino;
    }
    
    public Verkkosolmu(){
        
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
    
    public void setMatkaAlkuun(int matka){
        this.matkaalkuun = matka;
    }
    
    public int getMatkaAlkuun(){
        return matkaalkuun;
    }
    
    public void setMatkaLoppuun(int matka){
        this.matkaloppuun = matka;
    }
    
    public int getMatkaLoppuun(){
        return matkaloppuun;
    }
    
    public int[] getSijainti(){
        return sijainti;
    }
    
    public void setTulosolmu(int i, int j){
        tulosolmu = new int[2];
        tulosolmu[0] = i;
        tulosolmu[1] = j;
    }
    
    public int[] getTulosolmu(){
        return tulosolmu;
    }
    
    public void setSijaintiKeossa(int i){
        
    }
    
    public int getPaino(){
        return paino;
    }
    
    @Override
    public String toString(){
        return "Paino: "+paino+" Sijainti kartalla: "+sijainti[0]+", "+sijainti[1];
    }
    
    public boolean equals(Verkkosolmu vertaa){
        return sijainti[0] == vertaa.getSijainti()[0] && sijainti[1] == vertaa.getSijainti()[1];
    }
}
