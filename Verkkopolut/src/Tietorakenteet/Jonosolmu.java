/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class Jonosolmu {
    
    private Jonosolmu next;
    private int[] sijainti;
    /**
     * Konstruktori. Asettaa verkon koordinaatit.
     * @param i Rivin indeksi.
     * @param j Sarakkeen indeksi.
     */
    public Jonosolmu(int i, int j){
        sijainti = new int[2];
        sijainti[0] = i;
        sijainti[1] = j;
        next = null;
    }
    /**
     * Palauttaa jonossa olevan seuraavan olion.
     * @return seuraava jonosolmu.
     */
    public Jonosolmu getNext(){
        return next;
    }
    /**
     * Asettaa jonossa seuraavan olion.
     * @param next Jonosolmu
     */
    public void setNext(Jonosolmu next){
        this.next = next;
    }
    /**
     * Palauttaa Jonosolmun sisältävän koordinaatin.
     * @return Kokonaislukutaulukko. Sisältää koordinaatit järjestyksessä (rivi, sarake).
     */
    public int[] getSijainti(){
        return sijainti;
    }
}
