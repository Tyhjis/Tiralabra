/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

import java.util.Random;

/**
 * Satunnaisen luolaston generoimiseen käytetty luokka. Generoi yksinkertaisen luolaston, joka sisältää polun halutusta aloituspisteestä haluttuun lopetuspisteeseen.
 * @author Krisu
 */
public class Verkkogeneraattori {
     
    private int koko;
    
    public Verkkogeneraattori(){
        
    }
    /**
     * Generoi uuden luolaston ja palauttaa sen kokonaislukutaulukkona.
     * @param koko Labyrintin haluttu sivun pituus.
     * @param iAloitus Aloituksen rivin indeksi.
     * @param jAloitus Aloituksen sarakkeen indeksi.
     * @param iMaali Maalin rivin indeksi.
     * @param jMaali Maalin sarakkeen indeksi.
     * @return Kokonaislukutaulukko.
     */
    public int[][] generoiLuolasto(int koko, int iAloitus, int jAloitus, int iMaali, int jMaali){
        this.koko = koko;
        int[][] matriisi = new int[koko][koko];
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                matriisi[i][j] = 10;
            }
        }
        for(int i = 0; i < koko; i++){
            matriisi[iMaali][i] = 1;
        }
        for(int i = 0; i < koko; i++){
            matriisi[i][jMaali] = 1;
        }
        int[] sijainti = paataSuunta(iAloitus, jAloitus);
        while(true){
            matriisi[sijainti[0]][sijainti[1]] = 1;
            sijainti = paataSuunta(sijainti[0], sijainti[1]);
            if(sijainti[0] == iMaali || sijainti[1] == jMaali){
                break;
            }
        }
        return matriisi;
    }
    /**
     * Päättää satunnaisluvun avulla mihin suuntaan luolastoa kaivetaan.
     * @param i Nykyisen sijainnin rivin indeksi.
     * @param j Nykyisen sijainnin sarakkeen indeksi.
     * @return Kokonaislukutaulukko.
     */
    private int[] paataSuunta(int i, int j){
        Random r = new Random();
        int suunta = r.nextInt(4);
        int[] palkoord = new int[2];
        if(suunta == 0){
            if(tarkistin(i, j+1)){
                palkoord[0] = i;
                palkoord[1] = j+1;
            }
        }
        else if(suunta == 1){
            if(tarkistin(i+1, j)){
                palkoord[0] = i+1;
                palkoord[1] = j;
            }
        }
        else if(suunta == 2){
            if(tarkistin(i, j-1)){
                palkoord[0] = i;
                palkoord[1] = j-1;
            }
        }
        else if(suunta == 3){
            if(tarkistin(i-1, j)){
                palkoord[0] = i-1;
                palkoord[1] = j;
            }
        }
        return palkoord;
    }
    /**
     * Tarkistaa ovatko annetut parametrit matriisin rajojen sisäpuolella.
     * @param i Rivin indeksi.
     * @param j Sarakkeen indeksi.
     * @return Palauttaa true jos annetut parametrit ovat matriisin rajojen sisäpuolella.
     */
    private boolean tarkistin(int i, int j){
        return i >= 0 && i < this.koko && j >= 0 && j < this.koko;
    }
    /**
     * Tulostaa haluttaessa parametrina annetun kaksiulotteisen taulukon.
     * @param taulukko Kaksiulotteinnen kokonaislukutaulukko.
     */
    public void tulostaTaulukko(int[][] taulukko){
        int pituus = taulukko.length;
        for(int i = 0; i < pituus; i++){
            for(int j = 0; j < pituus; j++){
                if(taulukko[i][j] < 10){
                    System.out.print(taulukko[i][j]+"  ");
                }
                else{
                    System.out.print(taulukko[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }
    
    public int[][] luoVerkkoJossaRistikeskella(int koko){
        int[][] matriisi = new int[koko][koko];
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                matriisi[i][j] = 10;
            }
        }
        int puoli = koko/2;
        
        for (int i = 0; i < koko; i++){
            matriisi[i][puoli] = 1;
            matriisi[puoli][i] = 1;
            matriisi[0][i] = 1;
            matriisi[koko-1][i] = 1;
        }
        return matriisi;
    }
}
