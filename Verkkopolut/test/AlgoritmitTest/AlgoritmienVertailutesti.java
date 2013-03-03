/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmitTest;

import Algoritmit.AStar;
import Algoritmit.BellmanFord;
import Algoritmit.Dijkstra;
import Sovelluslogiikka.Kello;
import Tietorakenteet.Pino;
import Tietorakenteet.Verkkogeneraattori;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Krisu
 */
public class AlgoritmienVertailutesti {
    
    Verkkogeneraattori verkkogen;
    AStar astar;
    Dijkstra dijkstra;
    BellmanFord bman;
    Kello ajastin;
    
    public AlgoritmienVertailutesti() {
    }
    
    @Before
    public void setUp() {
        verkkogen = new Verkkogeneraattori();
        astar = new AStar();
        dijkstra = new Dijkstra();
        bman = new BellmanFord();
        ajastin = new Kello();
    }
    
    @Test
    public void vertaileAikoja1(){
        int[][] verkko = verkkogen.luoVerkkoJossaRistikeskella(30);
        ajaAlgot(verkko);
    }
    
    @Test
    public void vertaileAikoja2(){
        int[][] verkko = verkkogen.luoVerkkoJossaRistikeskella(50);
        ajaAlgot(verkko);
    }
    
    @Test
    public void vertaileAikoja3(){
        int[][] verkko = verkkogen.luoVerkkoJossaRistikeskella(70);
        ajaAlgot(verkko);
    }
    
    @Test
    public void vertailePolkujenPituuksia(){
        int[][] verkko = verkkogen.luoVerkkoJossaRistikeskella(30);
        haePolkujenKoot(verkko);
    }
    
    @Test
    public void vertailePolkujenPituuksia2(){
        int[][] verkko = verkkogen.luoVerkkoJossaRistikeskella(50);
        haePolkujenKoot(verkko);
    }
    
    @Test
    public void vertailePolkujenPituuksia3(){
        int[][] verkko = verkkogen.luoVerkkoJossaRistikeskella(70);
        haePolkujenKoot(verkko);
    }

    private void ajaAlgot(int[][] verkko) {
        astar.setGraph(verkko);
        dijkstra.setGraph(verkko);
        bman.setGraph(verkko);
        ajastin.aloita();
        astar.algoritmi(0, 0, verkko.length-1, verkko.length-1);
        ajastin.lopeta();
        double astarAika = ajastin.getAika();
        ajastin.aloita();
        dijkstra.algoritmi(0, 0);
        ajastin.lopeta();
        double dijkstraAika = ajastin.getAika();
        ajastin.aloita();
        bman.algoritmi(0, 0);
        ajastin.lopeta();
        double bmanAika = ajastin.getAika();
        System.out.println(astarAika+" "+dijkstraAika+" "+bmanAika);
        assertTrue(vertaa(astarAika, dijkstraAika));
        assertTrue(vertaa(dijkstraAika, bmanAika));
    }
    
    private void haePolkujenKoot(int[][] verkko){
        astar.setGraph(verkko);
        dijkstra.setGraph(verkko);
        bman.setGraph(verkko);
        astar.algoritmi(0, 0, verkko.length-1, verkko.length-1);
        Pino astarPolku = astar.getPolku(verkko.length-1, verkko.length-1);
        dijkstra.algoritmi(0, 0);
        Pino dijkstraPolku = dijkstra.getPolku(verkko.length-1, verkko.length-1);
        bman.algoritmi(0, 0);
        Pino bmanPolku = bman.getPolku(verkko.length-1, verkko.length-1);
        assertTrue(vertaa(astarPolku.getSize(), dijkstraPolku.getSize(), bmanPolku.getSize()));
    }
    
    private boolean vertaa(int koko1, int koko2, int koko3){
        return koko1 == koko2 && koko2 == koko3;
    }
    private boolean vertaa(double aika1, double aika2){
        return aika1 <= aika2;
    }
}
