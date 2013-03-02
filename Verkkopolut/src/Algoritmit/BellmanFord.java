/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import Tietorakenteet.Jono;
import Tietorakenteet.Pino;
import Tietorakenteet.Verkkosolmu;

/**
 *
 * @author Krisu
 */
public class BellmanFord {
    
    int[][] verkko;
    Verkkosolmu[][] kaytavaverkko;
    int[] viimeisinkoordinaatti;
    private Jono jono;
    /**
     * Konstruktori.
     * @param verkko asettaa läpikäytävän verkon.
     */
    public BellmanFord(int[][] verkko){
        this.verkko = verkko;
        int pituus = verkko.length;
        kaytavaverkko = new Verkkosolmu[pituus][pituus];
        jono = new Jono();
    }
    /**
     * Setteri Vaihtaa verkkoa haluttaessa.
     * @param verkko 
     */
    public void setGraph(int[][] verkko){
        this.verkko = verkko;
    }
    /**
     * Toteuttaa algoritmin.
     */
    public void algoritmi(int iAlku, int jAlku){
        initialiseSingleSource(iAlku,jAlku);
        int pituus = kaytavaverkko.length;
        int kaydytsolmut = 0;
        int[] sijainti;
        jono.queue(iAlku, jAlku);
        while(!jono.isEmpty()){
            kaydytsolmut++;
            sijainti = jono.dequeue();
            relaksoiVierussolmut(sijainti[0], sijainti[1]);
        }
        kaytavaverkko[iAlku][jAlku].poistaTulosolmu();
        System.out.println("BMan-Ford: "+kaydytsolmut);
    }

    private void relaksoiVierussolmut(int i, int j) {
        if(tarkistin(i+1, j)){
            relax(i, j, i+1, j);
        }
        if(tarkistin(i-1, j)){
            relax(i, j, i-1, j);
        }
        if(tarkistin(i, j+1)){
            relax(i, j, i, j+1);
        }
        if(tarkistin(i, j-1)){
            relax(i, j, i, j-1);
        }
    }
    /**
     * Tarkistaa, onko annetut koordinaatit verkon (eli kaksiulotteisen kokonaislukutaulukon) rajojen sisäpuolella.
     * @param i rivin numero.
     * @param j sarakkeen numero.
     * @return Palauttaa true, jos koordinaatit ovat rajojen sisäpuolella. Muuten false.
     */
    public boolean tarkistin(int i, int j){
        return i >= 0 && i < kaytavaverkko.length && j >= 0 && j < kaytavaverkko.length;
    }
    /**
     * Alustaa verkon solmut ennen läpikäyntiä.
     * @param a aloituskoordinaatti. Rivin numero.
     * @param b aloituskoordinaatti. Sarakkeen numero.
     */
    public void initialiseSingleSource(int a, int b){
        int pituus = kaytavaverkko.length;
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                kaytavaverkko[i][j] = new Verkkosolmu(Integer.MAX_VALUE);
                kaytavaverkko[i][j].setSijainti(i, j);
            }
        }
        kaytavaverkko[a][b].setPaino(0);
    }
    /**
     * Asettaa solmulle uuden painon, jos uusi on kevyempi kuin vanha.
     * @param i1 Tulosolmun rivin koordinaatti.
     * @param j1 Tulosolmun sarakkeen koordinaatti.
     * @param i2 Kohdesolmun rivin koordinaatti.
     * @param j2 Kohdesolmun sarakkeen koordinaatti.
     */
    public void relax(int i1, int j1, int i2, int j2){
        if(kaytavaverkko[i1][j1].getPaino() < Integer.MAX_VALUE){
            int uusipaino = kaytavaverkko[i1][j1].getPaino() + verkko[i2][j2];
            if(kaytavaverkko[i2][j2].getPaino() > uusipaino){
                kaytavaverkko[i2][j2].setPaino(uusipaino);
                kaytavaverkko[i2][j2].setTulosolmu(i1, j1);
                jono.queue(i2, j2);
            }
        }
    }
    /**
     * Palauttaa käydyn verkon uusine painoineen.
     * @return Kokonaislukutaulukko.
     */
    public Verkkosolmu[][] palautaKaytyVerkko(){
        return kaytavaverkko;
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
}
