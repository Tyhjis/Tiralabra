/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Algoritmit.AStar;
import Algoritmit.BellmanFord;
import Algoritmit.Dijkstra;
import Tietorakenteet.*;

/**
 *
 * @author Krisu
 */
public class Main {
    
    public static void main(String[] args){
        /*Minimikeko heap = new Minimikeko();
        heap.heapInsert(4);
        heap.heapInsert(2);
        heap.heapInsert(3);
        heap.heapInsert(6);
        heap.heapInsert(8);
        heap.heapInsert(1);
        int[] koke = heap.getHeap();
        int koko = heap.getHeapSize();
        tulostus(koko, koke);
        System.out.println(heap.heapDelMin());
        koke = heap.getHeap();
        koko = heap.getHeapSize();
        tulostus(koko, koke);
        System.out.println(heap.heapDelMin());
        koke = heap.getHeap();
        koko = heap.getHeapSize();
        tulostus(koko, koke);*/
        
        Verkot verkot = new Verkot();
        Dijkstra algo = new Dijkstra(verkot.pieni3);
        algo.algoritmi();
        Verkkosolmu[][] solmut = algo.palautaKaytyVerkko();
        tulostus2(solmut);
        System.out.println("");
        Pino polku = algo.getPolku(3,3);
        tulostaPino(polku);
        System.out.println("");
        
        BellmanFord bman = new BellmanFord(verkot.pieni3);
        bman.algoritmi();
        int[][] verkko = bman.palautaKaytyVerkko();
        tulostus(verkko);
        System.out.println("");
        
        AStar astar = new AStar(verkot.pieni3);
        astar.algoritmi(0, 0, 3, 3);
        Verkkosolmu[][] knots = astar.palautaKaytyVerkko();
        tulostus(knots);
        System.out.println("");
        Jono Jpolku = astar.getPolku();
        tulostaJono(Jpolku);
    }
    
    private static void tulostaPino(Pino polku){
        int[] tul;
        while(!polku.empty()){
            tul = polku.pop();
            System.out.println(tul[0]+", "+tul[1]);
        }
    }
    
    private static void tulostaJono(Jono polku){
        int[] tul;
        while(!polku.isEmpty()){
            tul = polku.dequeue();
            System.out.println(tul[0]+", "+tul[1]);
        }
    }

    private static void tulostus(int[][] verkko) {
        for(int i = 0; i < verkko.length; i++){
            for(int j = 0; j < verkko.length; j++){
                if(verkko[i][j] < 10){
                    System.out.print(verkko[i][j]+"  ");
                }
                else{
                    System.out.print(verkko[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }    
    
    private static void tulostus(Verkkosolmu[][] koke) {
        for(int i = 0; i < koke.length; i++){
            for(int j = 0; j < koke.length; j++){
                    System.out.print(koke[i][j].getMatkaLoppuun()+" ");                
            }
            System.out.println("");
        }
    }
    
    private static void tulostus2(Verkkosolmu[][] solmut){
        for(int i = 0; i < solmut.length; i++){
            for(int j = 0; j < solmut.length; j++){
                if(solmut[i][j].getPaino() < 10){
                    System.out.print(solmut[i][j].getPaino()+"  ");
                }
                else{
                    System.out.print(solmut[i][j].getPaino()+" ");
                }
            }
            System.out.println("");
        }
    }
}
