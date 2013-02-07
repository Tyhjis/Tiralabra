/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class Pino {
    
    private Pinosolmu huippu;
    
    public Pino(){
        huippu = null;
    }
    
    public void push(int[] tulosolmu){
        Pinosolmu uusi = new Pinosolmu(tulosolmu, huippu);
        huippu = uusi;
    }
    
    public int[] pop(){
        Pinosolmu pal = huippu;
        huippu = huippu.getSeur();
        return pal.getTulosolmu();
    }
    
    public boolean empty(){
        return huippu == null;
    }
}
