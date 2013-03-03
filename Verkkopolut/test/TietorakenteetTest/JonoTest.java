/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteetTest;

import Tietorakenteet.Jono;
import Tietorakenteet.Jonosolmu;
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
public class JonoTest {
    
    Jono jono;
    int[] solmu1, solmu2, solmu3, solmu4, testi;
    
    public JonoTest() {
    }
    
    @Before
    public void setUp() {
        jono = new Jono();
        solmu1 = new int[] {0,0};
        solmu2 = new int[] {1,1};
        solmu3 = new int[] {2,2};
        solmu4 = new int[] {3,3};
    }
    
    @Test
    public void testaaQueue(){
        assertTrue(jono.isEmpty());
        jono.queue(0, 0);
        assertTrue(!jono.isEmpty());
    }
    
    @Test
    public void testaaDequeue1(){
        jono.queue(0,0);
        jono.queue(1,1);
        testi = jono.dequeue();
        assertTrue(Arrays.equals(testi, solmu1));
    }
    
    @Test
    public void testaaDequeue2(){
        jono.queue(0, 0);
        jono.queue(1, 1);
        jono.queue(2, 2);
        jono.dequeue();
        testi = jono.dequeue();
        assertTrue(Arrays.equals(testi, solmu2));
    }
    
    @Test
    public void testaaDequeue3(){
        jono.queue(0, 0);
        jono.queue(1, 1);
        jono.queue(2, 2);
        jono.queue(3, 3);
        int[] testi2 = new int[2];
        testi2[0] = 0;
        testi2[1] = 0;
        while(!jono.isEmpty()){
            testi = jono.dequeue();
            assertTrue(Arrays.equals(testi, testi2));
            testi2[0]++;
            testi2[1]++;
        }
    }
}
