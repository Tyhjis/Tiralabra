/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteetTest;

import Tietorakenteet.Pino;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Krisu
 */
public class PinoTest {
    
    Pino pino;
    int[] koord1;
    int[] koord2;
    
    public PinoTest() {
    }
    
    @Before
    public void setUp() {
        pino = new Pino();
        koord1 = new int[] {1, 1};
        koord2 = new int[] {1, 0};
    }
    
    @Test
    public void testaaLisays(){
        pino.push(koord1);
        assertTrue(!pino.empty());
    }
    
    @Test
    public void testaaPop(){
        pino.push(koord1);
        pino.push(koord2);
        int[] testi = pino.pop();
        assertEquals(testi, koord2);
    }
    
    @Test
    public void testaaPop2(){
        pino.push(koord2);
        pino.push(koord1);
        int[] testi = pino.pop();
        assertEquals(testi, koord1);
    }
}
