/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class Pinosolmu {
    
    private int[] tulosolmu;
    private Pinosolmu seur;
    
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
