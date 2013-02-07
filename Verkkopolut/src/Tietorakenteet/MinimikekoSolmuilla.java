/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class MinimikekoSolmuilla {
    
    private Verkkosolmu[] keko;
    private int heapsize;
    
    public MinimikekoSolmuilla(int koko){
        keko = new Verkkosolmu[koko+1];
        heapsize = 0;
    }
    public void heapInsert(Verkkosolmu s){
        heapsize++;
        int i = heapsize;
        while(i > 1 && keko[parent(i)].getPaino() > s.getPaino()){
            keko[i] = keko[parent(i)];
            i = parent(i);
        }
        keko[i] = s;
    }    
    public Verkkosolmu[] getHeap(){
        return keko;
    }
    
    public int getHeapSize(){
        return heapsize;
    }
    
    public int getMaxSize(){
        return keko.length;
    }
    
    public Verkkosolmu heapDelMin(){
        Verkkosolmu min = keko[1];
        keko[1] = keko[heapsize];
        heapsize--;
        heapify(1);
        return min;
    }
    
    public void heapDecWeight(int sijainti){
        while(sijainti > 1 && keko[parent(sijainti)].getPaino() > keko[sijainti].getPaino()){
            vaihdaAlkioidenPaikkaa(sijainti, parent(sijainti));
            sijainti = parent(sijainti);
        }
    }
    
    public boolean empty(){
        return heapsize == 0;
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
            if(keko[vasen].getPaino() < keko[oikea].getPaino()){
                pienin = vasen;
            }
            else{
                pienin = oikea;
            }
            if(keko[indeksi].getPaino() > keko[pienin].getPaino()){
                vaihdaAlkioidenPaikkaa(indeksi, pienin);
                heapify(pienin);
            }
            else if(vasen == heapsize && keko[indeksi].getPaino() > keko[vasen].getPaino()){
                vaihdaAlkioidenPaikkaa(indeksi, vasen);
            }
        }
    }
    
    public void vaihdaAlkioidenPaikkaa(int eka, int toka){
        Verkkosolmu apu = keko[eka];
        keko[eka] = keko[toka];
        keko[toka] = apu;
    }
    
    public void tulostaKeko(){
        for(int i = 1; i <= heapsize; i++){
            System.out.println(keko[i].toString());
        }
    }
}
