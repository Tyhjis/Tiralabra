/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import Tietorakenteet.Minimikeko;
import Tietorakenteet.MinimikekoSolmuilla;
import Tietorakenteet.Pino;
import Tietorakenteet.Verkkosolmu;

/**
 *
 * @author Krisu
 */
public class Dijkstra {
    
    private int[][] verkko;
    private Verkkosolmu[][] kaytavaverkko;
    private MinimikekoSolmuilla keko;
    
    public Dijkstra(int[][] verkko){
        this.verkko = verkko;
        int maara = verkko.length*verkko.length;
        keko = new MinimikekoSolmuilla(maara);
    }
    
    public void setGraph(int[][] verkko){
        this.verkko = verkko;
    }
    
    public void initialiseSingleSource(){
        if(verkko != null){
            int pituus = verkko.length;
            kaytavaverkko = new Verkkosolmu[pituus][pituus];
            for(int i = 0; i < pituus; i++){
                for(int j = 0; j < pituus; j++){
                    kaytavaverkko[i][j] = new Verkkosolmu(Integer.MAX_VALUE);
                    kaytavaverkko[i][j].setSijainti(i, j);
                }
            }
            kaytavaverkko[0][0].setPaino(0);
        }
    }
    
    public void algoritmi(){
        int[] sij;
        Verkkosolmu vuorossa;
        initialiseSingleSource();
        //vieAlkiotKekoon();
        int kaydytsolmut = 0;
        keko.heapInsert(kaytavaverkko[0][0]);
        while(!keko.empty()){
            kaydytsolmut++;
            vuorossa = keko.heapDelMin();
            sij = vuorossa.getSijainti();
            if(tarkistin(sij[0], sij[1]+1)){
               relax(sij[0], sij[1], sij[0], sij[1]+1);
            }                
            if(tarkistin(sij[0], sij[1]-1)){
               relax(sij[0], sij[1], sij[0], sij[1]-1);
            }
            if(tarkistin(sij[0]+1, sij[1])){
               relax(sij[0], sij[1], sij[0]+1, sij[1]);
            }                
            if(tarkistin(sij[0]-1, sij[1])){
               relax(sij[0], sij[1], sij[0]-1, sij[1]);
            }
        }
        System.out.println("Dijkstra: "+kaydytsolmut);
    }
    
    public void vieAlkiotKekoon(){
        int pituus = verkko.length;
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                keko.heapInsert(kaytavaverkko[i][j]);
            }
        }
    }
    
    public void relax(int i1, int j1, int i2, int j2){
        if(kaytavaverkko[i2][j2].getPaino() > kaytavaverkko[i1][j1].getPaino() + verkko[i2][j2]){
            int uusipaino = kaytavaverkko[i1][j1].getPaino() + verkko[i2][j2];
            kaytavaverkko[i2][j2].setPaino(uusipaino);
            kaytavaverkko[i2][j2].setTulosolmu(i1, j1);
            keko.heapInsert(kaytavaverkko[i2][j2]);
        }
    }
    
    public Pino getPolku(int i, int j){
        Pino polku = new Pino();
        if(tarkistin(i, j)){
            int[] koord;
            int ti = i;
            int tj = j;
            polku.push(kaytavaverkko[ti][tj].getSijainti());
            while(kaytavaverkko[ti][tj].getTulosolmu() != null){
                koord = kaytavaverkko[ti][tj].getTulosolmu();
                polku.push(koord);
                ti = koord[0];
                tj = koord[1];
            }
        }

        return polku;
    }
    
    public boolean tarkistin(int i, int j){
        return i >= 0 && i < verkko.length && j >= 0 && j < verkko.length;
    }
    
    public Verkkosolmu[][] palautaKaytyVerkko(){
        return kaytavaverkko;
    }
    
}
