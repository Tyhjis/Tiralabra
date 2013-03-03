/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 * Linkitetyssä pinossa käytetty pinosolmu-olio. Käytetään verkkoalgoritmeissa polun generoimiseen.
 * @author Krisu
 */
public class Pinosolmu {
    
    private int[] tulosolmu;
    private Pinosolmu seur;
    
    /**
     * Konstruktori.
     * @param tulosolmu Verkon koordinaatit järjestyksessä (rivi, sarake).
     * @param seur Edellinen päällimmäinen solmu.
     */
    public Pinosolmu(int[] tulosolmu, Pinosolmu seur){
        this.tulosolmu = tulosolmu;
        this.seur = seur;
    }
   
    public Pinosolmu getSeur(){
        return seur;
    }
    
    public int[] getTulosolmu(){
        return tulosolmu;
    }
    
}
