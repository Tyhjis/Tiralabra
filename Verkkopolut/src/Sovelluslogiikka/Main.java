/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Algoritmit.BellmanFord;
import Algoritmit.Dijkstra;
import Tietorakenteet.Minimikeko;
import Tietorakenteet.Verkkosolmu;
import Tietorakenteet.Verkot;

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
        /*Dijkstra algo = new Dijkstra(verkot.pieni3);
        algo.algoritmi();
        Verkkosolmu[][] solmut = algo.palautaKaytyVerkko();
        tulostus(solmut);*/
        
        BellmanFord algo = new BellmanFord(verkot.pieni3);
        algo.algoritmi();
        int[][] verkko = algo.palautaKaytyVerkko();
        tulostus(verkko);
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
                if(koke[i][j].getPaino() < 10){
                    System.out.print(koke[i][j].getPaino()+"  ");
                }
                else{
                    System.out.print(koke[i][j].getPaino()+" ");
                }
            }
            System.out.println("");
        }
    }
}
