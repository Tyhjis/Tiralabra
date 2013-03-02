/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author Krisu
 */
public class Kello {
    
    double start;
    double end;
    
    public Kello(){
        start = 0;
        end = 0;
    }
    
    public void aloita(){
        start = System.currentTimeMillis();
    }
    
    public void lopeta(){
        end = System.currentTimeMillis();
    }
    
    public double getAika(){
        return end - start;
    }
}
