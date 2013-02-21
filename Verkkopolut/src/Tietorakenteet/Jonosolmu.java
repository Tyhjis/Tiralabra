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
    
    public Jonosolmu(int i, int j){
        sijainti = new int[2];
        sijainti[0] = i;
        sijainti[1] = j;
        next = null;
    }
    
    public Jonosolmu getNext(){
        return next;
    }
    
    public void setNext(Jonosolmu next){
        this.next = next;
    }
    
    public int[] getSijainti(){
        return sijainti;
    }
}
