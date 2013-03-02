/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Tietorakenteet.Verkkosolmu;

/**
 *
 * @author Krisu
 */
public class Laskin {
    
    public Laskin(){
        
    }
    
    public int laskeRelaksoitujenNodejenMaara(Verkkosolmu[][] verkko){
        int pituus = verkko.length;
        int maara = 0;
        
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                if(verkko[i][j].getTulosolmu() != null){
                    maara++;
                }
            }
        }
        return maara;
    }
}
