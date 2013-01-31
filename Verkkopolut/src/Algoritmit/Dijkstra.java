/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import Tietorakenteet.Minimikeko;
import Tietorakenteet.MinimikekoSolmuilla;

/**
 *
 * @author Krisu
 */
public class Dijkstra {
    
    private int[][] verkko;
    private int[][] kaytavaverkko;
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
            kaytavaverkko = new int[pituus][pituus];
            for(int i = 0; i < pituus; i++){
                for(int j = 0; j < pituus; j++){
                    kaytavaverkko[i][j] = Integer.MAX_VALUE;
                }
            }
            kaytavaverkko[0][0] = 0;
        }
    }
    
    public void algoritmi(){
        initialiseSingleSource();
        vieAlkiotKekoon();
        
    }
    
    public void vieAlkiotKekoon(){
        int pituus = verkko.length;
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                keko.heapInsert(kaytavaverkko[i][j], i, j);
            }
        }
    }
    
    public void relax(int i1, int j1, int i2, int j2){
        if(kaytavaverkko[i2][j2] > kaytavaverkko[i1][j1] + verkko[i2][j2]){
            kaytavaverkko[i2][j2] = kaytavaverkko[i1][j1] + verkko[i2][j2];
        }
    }
    
    public void tarkistin(){
        
    }
}
