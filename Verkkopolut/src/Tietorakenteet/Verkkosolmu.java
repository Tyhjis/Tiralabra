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
    private boolean suljettu;
    
    public Verkkosolmu(int paino){
        this.paino = paino;
        this.suljettu = false;
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
    /**
     * Asettaa painon aloitussolmusta tähän solmuun.
     * @param paino Kokonaisluku.
     */
    public void setPaino(int paino){
        this.paino = paino;
    }
    /**
     * Asettaa arvioidun matkan aloitussolmuun. Hyödynnetään A*-algoritmissa.
     * @param matka Kokonaisluku.
     */
    public void setMatkaAlkuun(int matka){
        this.matkaalkuun = matka;
    }
    /**
     * Palauttaa arvioidun matkan aloitussolmuun. Hyödynnetään A*-algoritmissa.
     * @return 
     */
    public int getMatkaAlkuun(){
        return matkaalkuun;
    }
    /**
     * Asettaa arvioidun matkan kohdesolmuun. Hyödynnetään A*-algoritmissa.
     * @param matka Kokonaisluku.
     */
    public void setMatkaLoppuun(int matka){
        this.matkaloppuun = matka;
    }
    /**
     * Palauttaa arvioidun matkan kohdesolmuun. Hyödynnetään A-algoritmissa.
     * @return 
     */
    public int getMatkaLoppuun(){
        return matkaloppuun;
    }
    /**
     * Palauttaa solmun sijainnin matriisissa.
     * @return Kokonaislukutaulukko. Indeksi 0 sisältää rivin indeksin. Indeksi 1 sisältää sarakkeen indeksin.
     */
    public int[] getSijainti(){
        return sijainti;
    }
    /**
     * Asettaa koordinaatit, josta tähän solmuun on tultu.
     * @param i Matriisin rivin koordinaatti.
     * @param j Matriisin sarakkeen koordinaatti.
     */    
    public void setTulosolmu(int i, int j){
        tulosolmu = new int[2];
        tulosolmu[0] = i;
        tulosolmu[1] = j;
    }
    /**
     * Palauttaa tulosolmun koordinaatit.
     * @return Kokonaislukutaulukko. Indeksi 0 sisältää rivin indeksin. Indeksi 1 sisältää sarakkeen indeksin.
     */
    public int[] getTulosolmu(){
        return tulosolmu;
    }
    /**
     * Poistaa tulosolmun haluttaessa.
     */
    public void poistaTulosolmu(){
        this.tulosolmu = null;
    }
    /**
     * Asettaa solmun suljetuksi. Hyädynnetään A*-algoritmissa. Edustaa ns. "Suljettua joukkoa".
     */
    public void asetaSuljetuksi(){
        this.suljettu = true;
    }
    /**
     * Kertoo, onko solmu suljetussa joukossa. Hyödynnetään A*-algoritmissa.
     * @return palauttaa true, jos solmu on suljettu.
     */
    public boolean onkoSuljettu(){
        return this.suljettu;
    }
    /**
     * Palauttaa solmuun asetetun painon.
     * @return Kokonaisluku.
     */
    public int getPaino(){
        return paino;
    }
    /**
     * Palauttaa String-olion, joka kertoo solmun sijainnin matriisissa, sekä solmulle asetetun painon.
     * @return 
     */
    @Override
    public String toString(){
        return "Paino: "+paino+" Sijainti kartalla: "+sijainti[0]+", "+sijainti[1];
    }
}
