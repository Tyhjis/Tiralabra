/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Tietorakenteet.Verkkogeneraattori;
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
        Kello aika = new Kello();
        Verkkogeneraattori gen = new Verkkogeneraattori();
        int[][] verkko = gen.generoiLabyrintti(100, 1, 1, 45, 30);
        int pituus = verkko.length - 1;
        Verkot verkot = new Verkot();
        Pino polku1;
        Pino polku2;
        Pino polku3;
        Visualisoija v = new Visualisoija();
        v.setVerkko(verkko);
        
        Dijkstra algo = new Dijkstra(verkko);
        aika.aloita();
        algo.algoritmi(1, 1);
        aika.lopeta();
        System.out.println(aika.getAika()+" ms");
        Verkkosolmu[][] solmut = algo.palautaKaytyVerkko();
        
        System.out.println("");
        polku1 = algo.getPolku(45,30);
        tulostaPino(polku1);
        System.out.println("");
        
        BellmanFord bman = new BellmanFord(verkko);
        aika.aloita();
        bman.algoritmi(1, 1);
        aika.lopeta();
        System.out.println(aika.getAika()+" ms");
        
        System.out.println("");
        polku2 = bman.getPolku(45, 30);
        tulostaPino(polku2);
        System.out.println("");
        
        AStar astar = new AStar(verkko);
        aika.aloita();
        astar.algoritmi(1, 1, 45,30);
        aika.lopeta();
        System.out.println(aika.getAika()+" ms");
        Verkkosolmu[][] knots = astar.palautaKaytyVerkko();
        polku3 = astar.getPolku(45,30);
       // v.visualisoiPolut(polku1, polku3);
        //v.visualisoiPolku(polku3);
        tulostaPino(polku3);
        //v.tulostaVerkko();
        //String tark = tarkistaOnkoPolutSamat(polku1, polku3);
        Laskin laskin = new Laskin();
        //System.out.println("Dijkstran relaksointi: "+laskin.laskeRelaksoitujenNodejenMaara(solmut));
        System.out.println("A*:n relaksointi: "+laskin.laskeRelaksoitujenNodejenMaara(knots));
        //System.out.println(tark);*/
    }
    
    private static String tarkistaOnkoPolutSamat(Pino pino1, Pino pino2){
        Pino comp1 = pino1;
        Pino comp2 = pino2;
        if(pino1.getSize() != pino2.getSize()){
            return "Pinot olivat eri kokoiset: Dijkstra: "+pino1.getSize()+" A*: "+pino2.getSize();
        }
        System.out.println("Polkujen pituudet: "+pino1.getSize());
        int[] vert1;
        int[] vert2;
        int ind = 0;
        while(!comp1.empty()){
            ind++;
            vert1 = comp1.pop();
            vert2 = comp2.pop();
            if(vert1[0] != vert2[0] || vert1[1] != vert2[1]){
                return "Alkiot olivat erilaiset: Dijkstra: ("+vert1[0]+", "+vert1[1]+") A*: ("+vert2[0]+", "+vert2[1]+") indeksi: "+ind;
            }
        }
        return "Polut olivat samanlaiset";
    }
    
    private static void tulostaPino(Pino polku){
        //int[] tul;
        System.out.println("Pituus: "+polku.getSize());
        /*while(!polku.empty()){
            tul = polku.pop();
            System.out.println(tul[0]+", "+tul[1]);
        }*/
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
        System.out.println("");
        for(int i = 0; i < koke.length; i++){
            for(int j = 0; j < koke.length; j++){
                    System.out.print(koke[i][j].getMatkaAlkuun()+" ");                
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
