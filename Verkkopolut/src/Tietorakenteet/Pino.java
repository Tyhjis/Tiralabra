/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 * Pääasiassa verkon polun generoimiseen käytetty tietorakenne.
 * @author Krisu
 */
public class Pino {
    
    private Pinosolmu huippu;
    private int size;
    
    /**
     * Konstruktori.
     */
    public Pino(){
        huippu = null;
        this.size = 0;
    }
    /**
     * Luo ja lisää uuden solmun pinoon.
     * @param tulosolmu Koordinaatit matriisissa.
     */
    public void push(int[] tulosolmu){
        Pinosolmu uusi = new Pinosolmu(tulosolmu, huippu);
        huippu = uusi;
        this.size++;
    }
    /**
     * Poistaa ja palauttaa pinon päällimmäisen olion.
     * @return Kokonaislukutaulukko, joka sisältää koordinaatit järjestyksessä (rivi, sarake).
     */
    public int[] pop(){
        Pinosolmu pal = huippu;
        huippu = huippu.getSeur();
        this.size--;
        return pal.getTulosolmu();
    }
    /**
     * Kertoo, onko pino tyhjä.
     * @return Palauttaa true jos pino on tyhjä.
     */
    public boolean empty(){
        return huippu == null;
    }
    /**
     * Palauttaa Pinon koon.
     * @return Kokonaisluku.
     */
    public int getSize(){
        return this.size;
    }
}
