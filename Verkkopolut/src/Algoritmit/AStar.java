/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import Tietorakenteet.Jono;
import Tietorakenteet.MinimikekoSolmuilla;
import Tietorakenteet.Verkkosolmu;

/**
 *
 * @author Krisu
 */
public class AStar {
    
    int[][] verkko;
    int[] alku;
    int[] loppu;
    Verkkosolmu[][] kaytavaverkko;
    MinimikekoSolmuilla keko;
    Jono polku;
    /**
     * Konstruktori. Asettaa verkon.
     * @param verkko Kokonaislukutaulukko.
     */
    public AStar(int[][] verkko){
        this.verkko = verkko;
        int pituus = verkko.length;
        int maara = pituus*pituus;
        kaytavaverkko = new Verkkosolmu[pituus][pituus];
        keko = new MinimikekoSolmuilla(maara);
    }
    /**
     * Asettaa haluttaessa uuden verkon.
     * @param verkko Kokonaislukutaulukko.
     */
    public void setGraph(int[][] verkko){
        this.verkko = verkko;
    }
    /**
     * 
     * @param iAlku
     * @param jAlku
     * @param iLoppu
     * @param jLoppu 
     */
    public void algoritmi(int iAlku, int jAlku, int iLoppu, int jLoppu){
        asetaVerkonArvioidutEtaisyydet(iAlku, jAlku, iLoppu, jLoppu);
        Verkkosolmu vuorossa = kaytavaverkko[iAlku][jAlku];
        int kaydytsolmut = 0;
        int[] sijainti;
        int i;
        int j;
        polku = new Jono();
        
        while(vuorossa != kaytavaverkko[iLoppu][jLoppu]){
            kaydytsolmut++;
            sijainti = vuorossa.getSijainti();
            i = sijainti[0];
            j = sijainti[1];
            polku.queue(i, j);            
            if(tarkistaRajat(i, j+1)){
                laskePaino(i, j, i, j+1);
            }
            if(tarkistaRajat(i, j-1)){
                laskePaino(i, j, i, j-1);
            }
            if(tarkistaRajat(i+1, j)){
                laskePaino(i, j, i+1, j);
            }
            if(tarkistaRajat(i-1, j)){
                laskePaino(i, j, i-1, j);
            }
            vuorossa = keko.heapDelMin();
        }
        System.out.println("A*: "+kaydytsolmut);
        polku.queue(iLoppu, jLoppu);
    }
    
    public void asetaVerkonArvioidutEtaisyydet(int iAlku, int jAlku, int iLoppu, int jLoppu){
        int pituus = kaytavaverkko.length;
        for(int i = 0; i < pituus; i++){
            for(int j = 0; j < pituus; j++) {
                kaytavaverkko[i][j] = new Verkkosolmu();
                kaytavaverkko[i][j].setSijainti(i, j);
                kaytavaverkko[i][j].setPaino(Integer.MAX_VALUE);
                kaytavaverkko[i][j].setMatkaLoppuun(arvioiEtaisyysPisteeseen(i, j, iLoppu, jLoppu));
            }
        }
    }
    
    public int arvioiEtaisyysPisteeseen(int i1, int j1, int i2, int j2){        
        return Math.abs(i1-i2)+Math.abs(j1-j2);
    }
    
    public void laskePaino(int i1, int j1, int i2, int j2){
        int uusipaino = verkko[i2][j2] + kaytavaverkko[i2][j2].getMatkaLoppuun();
        kaytavaverkko[i2][j2].setPaino(uusipaino);
        keko.heapInsert(kaytavaverkko[i2][j2]);
    }
    
    public boolean tarkistaRajat(int i, int j){
        return i >= 0 && i < verkko.length && j >= 0 && j < verkko[i].length;
    }
    
    public Verkkosolmu[][] palautaKaytyVerkko(){
        return kaytavaverkko;
    }
    
    public Jono getPolku(){
        return polku;
    }
}
