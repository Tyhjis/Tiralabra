/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmitTest;

import Algoritmit.BellmanFord;
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
public class BellmanFordTest {
    
    BellmanFord bman;
    Pino polku;
    Verkkogeneraattori verkkogen;
    int[][] verkko;
    
    public BellmanFordTest() {
    }
    
    @Before
    public void setUp() {
        bman = new BellmanFord();
        verkkogen = new Verkkogeneraattori();
    }
    
    @Test
    public void testaaAlgo1(){
        verkko = verkkogen.generoiLuolasto(10, 0, 0, 9, 9);
        bman.setGraph(verkko);
        bman.algoritmi(0, 0);
        polku = bman.getPolku(9, 9);
        assertTrue(!polku.empty());
    }
    
    @Test
    public void testaaAlgo2(){
        verkko = verkkogen.generoiLuolasto(20, 0, 0, 19, 19);
        bman.setGraph(verkko);
        bman.algoritmi(0, 0);
        polku = bman.getPolku(19, 19);
        int[] testi1 = new int[] {0,0};
        int[] testi2 = new int[] {19, 19};
        int[] verrattava = polku.pop();
        assertTrue(Arrays.equals(testi1, verrattava));
        while(!polku.empty()){
            verrattava = polku.pop();
        }
        assertTrue(Arrays.equals(testi2, verrattava));
    }
    
    
}
