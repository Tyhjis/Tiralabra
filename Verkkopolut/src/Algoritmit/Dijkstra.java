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
 * Dijkstran algoritmi.
 * @author Krisu
 */
public class Dijkstra {
    
    private int[][] verkko;
    private Verkkosolmu[][] kaytavaverkko;
    private MinimikekoSolmuilla keko;
    
    public Dijkstra(int[][] verkko){
        asetaOliomuuttujat(verkko);
    }

    public Dijkstra(){
        
    }
    
    private void asetaOliomuuttujat(int[][] verkko) {
        this.verkko = verkko;
        int maara = verkko.length*verkko.length;
        keko = new MinimikekoSolmuilla(maara);
    }
    
    public void setGraph(int[][] verkko){
        asetaOliomuuttujat(verkko);
    }
    /**
     * Alustaa käytävän verkon.
     * @param iAlku Aloitussolmun rivin indeksi.
     * @param jAlku Aloitussolmun sarakkeen indeksi.
     */
    public void initialiseSingleSource(int iAlku, int jAlku){
        if(verkko != null){
            int pituus = verkko.length;
            kaytavaverkko = new Verkkosolmu[pituus][pituus];
            for(int i = 0; i < pituus; i++){
                for(int j = 0; j < pituus; j++){
                    kaytavaverkko[i][j] = new Verkkosolmu(Integer.MAX_VALUE);
                    kaytavaverkko[i][j].setSijainti(i, j);
                }
            }
            kaytavaverkko[iAlku][jAlku].setPaino(0);
        }
    }
    /**
     * Toteuttaa algoritmin.
     * @param iAlku Aloitussolmun rivin indeksi.
     * @param jAlku Aloitussolmun sarakkeen indeksi.
     */
    public void algoritmi(int iAlku, int jAlku){
        int[] sij;
        Verkkosolmu vuorossa;
        initialiseSingleSource(iAlku, jAlku);
        int kaydytsolmut = 0;
        keko.heapInsert(kaytavaverkko[iAlku][jAlku]);
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
        System.out.println("Dijkstran käytyjen solmujen lkm: "+kaydytsolmut);
    }
    /**
     * Löysentää vuorossa olevan solmun vierussolmun, jos sen paino on pienempi kuin uusi paino. Asettaa solmun samalla tarvittaessa minimikekoon.
     * @param i1 Vuorossa olevan solmun rivin indeksi.
     * @param j1 Vuorossa olevan solmun sarakkeen indeksi.
     * @param i2 Vierussolmun rivin indeksi.
     * @param j2 Vierussolmun sarakkeen indeksi.
     */
    public void relax(int i1, int j1, int i2, int j2){
        if(kaytavaverkko[i2][j2].getPaino() > kaytavaverkko[i1][j1].getPaino() + verkko[i2][j2]){
            int uusipaino = kaytavaverkko[i1][j1].getPaino() + verkko[i2][j2];
            kaytavaverkko[i2][j2].setPaino(uusipaino);
            kaytavaverkko[i2][j2].setTulosolmu(i1, j1);
            keko.heapInsert(kaytavaverkko[i2][j2]);
        }
    }
    /**
     * Generoi ja palauttaa lyhyimmän polun pinona.
     * @param i Kohdesolmun rivin indeksi.
     * @param j Kohdesolmun sarakkeen indeksi.
     * @return Pino.
     */
    public Pino getPolku(int i, int j){
        Pino polku = new Pino();
        if(tarkistin(i, j)){
            int[] koord;
            int ti = i;
            int tj = j;
            polku.push(kaytavaverkko[ti][tj].getSijainti());
            koord = kaytavaverkko[ti][tj].getTulosolmu();
            while(kaytavaverkko[ti][tj].getTulosolmu() != null){
                koord = kaytavaverkko[ti][tj].getTulosolmu();
                polku.push(koord);
                ti = koord[0];
                tj = koord[1];
            }
        }

        return polku;
    }
    /**
     * Tarkistaa, ovatko annetut parametrit verkon rajojen sisäpuolella.
     * @param i Tarkistettava rivin indeksi.
     * @param j Tarkistettava sarakkeen indeksi.
     * @return Palauttaa true, jos parametrit ovat rajojen sisäpuolella.
     */
    private boolean tarkistin(int i, int j){
        return i >= 0 && i < verkko.length && j >= 0 && j < verkko.length;
    }
    /**
     * Palauttaa haluttaessa käydyn verkon.
     * @return Kaksiulotteinen Verkkosolmu-taulukko.
     */
    public Verkkosolmu[][] palautaKaytyVerkko(){
        return kaytavaverkko;
    }
    
}
