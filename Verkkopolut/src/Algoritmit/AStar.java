/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import Tietorakenteet.*;
import java.util.Arrays;

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
    /**
     * Konstruktori. Asettaa verkon.
     * @param verkko Kokonaislukutaulukko.
     */
    public AStar(int[][] verkko){
        this.verkko = verkko;
        asetaOlioMuuttujat(verkko);
    }

    private void asetaOlioMuuttujat(int[][] verkko) {
        int pituus = verkko.length;
        kaytavaverkko = new Verkkosolmu[pituus][pituus];
        this.loppu = new int[2];
        int maara = pituus * pituus;
        keko = new MinimikekoSolmuilla(maara);
    }
    
    public AStar(){
        keko = new MinimikekoSolmuilla();
    }
    /**
     * Asettaa haluttaessa uuden verkon.
     * @param verkko Kokonaislukutaulukko.
     */
    public void setGraph(int[][] verkko){
        this.verkko = verkko;
        asetaOlioMuuttujat(verkko);
    }
    /**
     * Toteuttaa A*-algoritmin.
     * @param iAlku Aloitussolmun rivin indeksi.
     * @param jAlku Aloitussolmun sarakkeen indeksi.
     * @param iLoppu Kohdesolmun rivin indeksi.
     * @param jLoppu Kohdesolmun sarakkeen indeksi.
     */
    public void algoritmi(int iAlku, int jAlku, int iLoppu, int jLoppu){
        asetaVerkonArvioidutEtaisyydet(iAlku, jAlku, iLoppu, jLoppu);
        Verkkosolmu vuorossa;
        loppu[0] = iLoppu;
        loppu[1] = jLoppu;
        int[] sijainti = new int[2];
        sijainti[0] = iAlku;
        sijainti[1] = jAlku;
        keko.heapInsert(kaytavaverkko[iAlku][jAlku]);
        int lkm = 0;
        while(!Arrays.equals(sijainti, loppu)){
            lkm++;
            vuorossa = keko.heapDelMin();
            vuorossa.asetaSuljetuksi();
            sijainti = vuorossa.getSijainti();
            laskeVierussolmujenPainot(sijainti[0], sijainti[1]);
        }
        kaytavaverkko[iAlku][jAlku].poistaTulosolmu();
        System.out.println("A*:n käytyjen solmujen lkm: "+lkm);
    }
    /**
     * 
     * @param i
     * @param j 
     */
    private void laskeVierussolmujenPainot(int i, int j){
        if(tarkistaRajat(i, j+1)){
            laskePaino(i, j, i, j+1);
        }
        if(tarkistaRajat(i+1, j)){
            laskePaino(i, j, i+1, j);
        }
        if(tarkistaRajat(i, j-1)){
            laskePaino(i, j, i, j-1);
        }
        if(tarkistaRajat(i-1, j)){
            laskePaino(i, j, i-1, j);
        }
    }
    /**
     * Laskee ja asettaa painon vierussolmulle.
     * @param i1 Vuorossa olevan solmun rivin indeksi.
     * @param j1 Vuorossa olevan solmun sarakkeen. indeksi.
     * @param i2 Vierussolmun rivin indeksi.
     * @param j2 Vierussolmun sarakkeen indeksi.
     */    
    private void laskePaino(int i1, int j1, int i2, int j2){
        if(verkko[i2][j2] != 10){
           int uusipaino = kaytavaverkko[i1][j1].getPaino() + verkko[i2][j2] + kaytavaverkko[i2][j2].getMatkaLoppuun() + kaytavaverkko[i2][j2].getMatkaAlkuun();
        if(kaytavaverkko[i2][j2].getPaino() > uusipaino){
            kaytavaverkko[i2][j2].setTulosolmu(i1, j1);
            kaytavaverkko[i2][j2].setPaino(uusipaino);
            keko.heapInsert(kaytavaverkko[i2][j2]);            
        } 
        }
    }
    /**
     * 
     * @param iAlku
     * @param jAlku
     * @param iLoppu
     * @param jLoppu 
     */
    private void asetaVerkonArvioidutEtaisyydet(int iAlku, int jAlku, int iLoppu, int jLoppu){
        int pituus = kaytavaverkko.length;
        for(int i = 0; i < pituus; i++){
            for(int j = 0; j < pituus; j++) {
                kaytavaverkko[i][j] = new Verkkosolmu();
                kaytavaverkko[i][j].setSijainti(i, j);
                kaytavaverkko[i][j].setPaino(Integer.MAX_VALUE);
                kaytavaverkko[i][j].setMatkaLoppuun(arvioiEtaisyysPisteeseen(i, j, iLoppu, jLoppu));
                kaytavaverkko[i][j].setMatkaAlkuun(arvioiEtaisyysPisteeseen(i, j, iAlku, jAlku));
            }
        }
        kaytavaverkko[iAlku][jAlku].setPaino(0);
    }
    /**
     * Arvioi kahden solmun välisen etäisyyden. Manhattan-etäisyys.
     * @param i1 arvioitavan solmun rivin sijainti.
     * @param j1 arvioitavan solmun sarakkeen sijainti.
     * @param i2 kohdesolmun rivin sijainti.
     * @param j2 kohdesolmun sarakkeen sijainti.
     * @return palauttaa arvioidun etäisyyden kokonaislukuna.
     */
    public int arvioiEtaisyysPisteeseen(int i1, int j1, int i2, int j2){        
        return Math.abs(i1-i2)+Math.abs(j1-j2);
    }
    /**
     * Tarkistaa, onko annetut koordinaatit matriisin rajojen sisäpuolella.
     * @param i Rivin indeksi.
     * @param j Sarakkeen indeksi.
     * @return Palauttaa true, jos koordinaatit ovat rajojen sisäpuolella.
     */
    private boolean tarkistaRajat(int i, int j){
        return i >= 0 && i < verkko.length && j >= 0 && j < verkko[i].length;
    }
    /**
     * Palauttaa 
     * @return 
     */
    public Verkkosolmu[][] palautaKaytyVerkko(){
        return kaytavaverkko;
    }
        
    public Pino getPolku(int i, int j){
        Pino polku = new Pino();
        if(tarkistaRajat(i, j)){
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
}
