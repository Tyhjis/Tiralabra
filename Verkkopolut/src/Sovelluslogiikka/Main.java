/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Tietorakenteet.Minimikeko;

/**
 *
 * @author Krisu
 */
public class Main {
    
    public static void main(String[] args){
        Minimikeko heap = new Minimikeko();
        
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
        tulostus(koko, koke);
    }

    private static void tulostus(int koko, int[] koke) {
        for(int i = 1; i <= koko; i++){
            System.out.print(koke[i]+" ");
        }
        System.out.println("");
    }
}
