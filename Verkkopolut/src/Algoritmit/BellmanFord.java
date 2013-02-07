/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

/**
 *
 * @author Krisu
 */
public class BellmanFord {
    
    int[][] verkko;
    int[][] kaytavaverkko;
    
    public BellmanFord(int[][] verkko){
        this.verkko = verkko;
        int pituus = verkko.length;
        kaytavaverkko = new int[pituus][pituus];
    }
    
    public void algoritmi(){
        initialiseSingleSource(0,0);
        int pituus = kaytavaverkko.length;
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
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
        }
    }
    
    public boolean tarkistin(int i, int j){
        return i >= 0 && i < kaytavaverkko.length && j >= 0 && j < kaytavaverkko.length;
    }
    
    public void initialiseSingleSource(int a, int b){
        int pituus = kaytavaverkko.length;
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                kaytavaverkko[i][j] = Integer.MAX_VALUE;
            }
        }
        kaytavaverkko[a][b] = 0;
    }
    
    public void relax(int i1, int j1, int i2, int j2){
        int uusipaino = kaytavaverkko[i1][j1] + verkko[i2][j2];
        if(kaytavaverkko[i2][j2] > uusipaino){
            kaytavaverkko[i2][j2] = uusipaino;
        }
    }
    
    public int[][] palautaKaytyVerkko(){
        return kaytavaverkko;
    }
}
