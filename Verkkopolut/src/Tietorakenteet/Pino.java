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
    private int size;
    
    public Pino(){
        huippu = null;
        this.size = 0;
    }
    
    public void push(int[] tulosolmu){
        Pinosolmu uusi = new Pinosolmu(tulosolmu, huippu);
        huippu = uusi;
        this.size++;
    }
    
    public int[] pop(){
        Pinosolmu pal = huippu;
        huippu = huippu.getSeur();
        this.size--;
        return pal.getTulosolmu();
    }
    
    public boolean empty(){
        return huippu == null;
    }
    
    public int getSize(){
        return this.size;
    }
}
