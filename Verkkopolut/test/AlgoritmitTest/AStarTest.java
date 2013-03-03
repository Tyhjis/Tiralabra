package AlgoritmitTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Algoritmit.AStar;
import Tietorakenteet.Pino;
import Tietorakenteet.Verkkogeneraattori;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Krisu
 */
public class AStarTest {
    
    AStar astar;
    Verkkogeneraattori verkkogen;
    int[][] verkko;
    Pino polku;
    
    public AStarTest() {
    }
    
    @Before
    public void setUp() {
        verkkogen = new Verkkogeneraattori();
        astar = new AStar();
    }
    
    @Test
    public void testaaAlgo1(){
        verkko = verkkogen.generoiLuolasto(10, 0, 0, 9, 9);
        astar.setGraph(verkko);
        astar.algoritmi(0, 0, 9, 9);
        polku = astar.getPolku(9, 9);
        assertTrue(!polku.empty());
    }
    
    @Test
    public void testaaAlgo2(){
        verkko = verkkogen.generoiLuolasto(20, 0, 0, 19, 19);
        astar.setGraph(verkko);
        astar.algoritmi(0, 0, 19, 19);
        int[] testi1 = new int[] {0, 0};
        int[] testi2 = new int[] {19, 19};
        polku = astar.getPolku(19, 19);
        int[] testi3 = polku.pop();
        assertTrue(Arrays.equals(testi1, testi3));
        while(!polku.empty()){
            testi3 = polku.pop();
        }
        assertTrue(Arrays.equals(testi3, testi2));
    }
}
