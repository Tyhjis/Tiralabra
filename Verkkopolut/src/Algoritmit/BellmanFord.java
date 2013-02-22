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
    /**
     * Konstruktori.
     * @param verkko asettaa läpikäytävän verkon.
     */
    public BellmanFord(int[][] verkko){
        this.verkko = verkko;
        int pituus = verkko.length;
        kaytavaverkko = new int[pituus][pituus];
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
    public void algoritmi(){
        initialiseSingleSource(0,0);
        int pituus = kaytavaverkko.length;
        int kaydytsolmut = 0;
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                kaydytsolmut++;
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
        System.out.println("BMan-Ford: "+kaydytsolmut);
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
                kaytavaverkko[i][j] = Integer.MAX_VALUE;
            }
        }
        kaytavaverkko[a][b] = 0;
    }
    /**
     * Asettaa solmulle uuden painon, jos uusi on kevyempi kuin vanha.
     * @param i1 Tulosolmun rivin koordinaatti.
     * @param j1 Tulosolmun sarakkeen koordinaatti.
     * @param i2 Kohdesolmun rivin koordinaatti.
     * @param j2 Kohdesolmun sarakkeen koordinaatti.
     */
    public void relax(int i1, int j1, int i2, int j2){
        int uusipaino = kaytavaverkko[i1][j1] + verkko[i2][j2];
        if(kaytavaverkko[i2][j2] > uusipaino){
            kaytavaverkko[i2][j2] = uusipaino;
        }
    }
    /**
     * Palauttaa käydyn verkon uusine solmuineen.
     * @return Kokonaislukutaulukko.
     */
    public int[][] palautaKaytyVerkko(){
        return kaytavaverkko;
    }
}
