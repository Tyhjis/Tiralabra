/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class Minimikeko {
    
    int[] keko;
    int heapsize;
    
    public Minimikeko(){
        keko = new int[16];
        heapsize = 0;
    }
    
    public void heapInsert(int avain){
        heapsize++;
        int i = heapsize;
        while(i > 1 && keko[parent(i)] > avain){
            keko[i] = keko[parent(i)];
            i = parent(i);
        }
        keko[i] = avain;
    }
    
    public int[] getHeap(){
        return keko;
    }
    
    public int getHeapSize(){
        return heapsize;
    }
    
    public int heapDelMin(){
        int min = keko[1];
        keko[1] = keko[heapsize];
        heapsize--;
        heapify(1);
        return min;
    }
    
    public int heapMin(int[] keko){
        return keko[1];
    }
    
    public int left(int indeksi){
        return 2*indeksi;
    }
    
    public int right(int indeksi){
        return 2*indeksi+1;
    }
    
    public int parent(int indeksi){
        return indeksi/2;
    }
    
    public void heapify(int indeksi){
        int vasen = left(indeksi);
        int oikea = right(indeksi);
        int pienin;
        if(oikea <= heapsize){
            if(keko[vasen] < keko[oikea]){
                pienin = vasen;
            }
            else{
                pienin = oikea;
            }
            if(keko[indeksi] > keko[pienin]){
                vaihdaAlkioidenPaikkaa(indeksi, pienin);
                heapify(pienin);
            }
            else if(vasen == heapsize && keko[indeksi] > keko[vasen]){
                vaihdaAlkioidenPaikkaa(indeksi, vasen);
            }
        }
    }
    
    public void vaihdaAlkioidenPaikkaa(int eka, int toka){
        int apu = keko[eka];
        keko[eka] = keko[toka];
        keko[toka] = apu;
    }
}
