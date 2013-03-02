/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteetTest;

import Tietorakenteet.MinimikekoSolmuilla;
import Tietorakenteet.Verkkosolmu;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Krisu
 */
public class MinimikekoSolmuillaTest {
    
    MinimikekoSolmuilla keko;
    Verkkosolmu testi1;
    Verkkosolmu testi2;
    Verkkosolmu testi3;
    Verkkosolmu testi4;
    
    public MinimikekoSolmuillaTest() {
    }
    
    @Before
    public void setUp() {
        keko = new MinimikekoSolmuilla();
        testi1 = new Verkkosolmu();
        testi1.setPaino(1);
        testi2 = new Verkkosolmu();
        testi2.setPaino(2);
        testi3 = new Verkkosolmu();
        testi3.setPaino(3);
        testi4 = new Verkkosolmu();
        testi4.setPaino(4);
    }
    
    @Test
    public void testaaLisays(){
        keko.heapInsert(testi1);
        keko.heapInsert(testi2);
        keko.heapInsert(testi3);
        keko.heapInsert(testi4);
        assertEquals(keko.getHeapSize(), 4);
    }
    
    @Test
    public void testaaPoisto(){
        keko.heapInsert(testi1);
        keko.heapInsert(testi2);
        keko.heapInsert(testi3);
        keko.heapInsert(testi4);
        keko.heapDelMin();
        assertEquals(keko.getHeapSize(), 3);
    }
    
    @Test
    public void testaaKekoEhto1(){
        keko.heapInsert(testi1);
        keko.heapInsert(testi2);
        keko.heapInsert(testi3);
        keko.heapInsert(testi4);
        Verkkosolmu apu = keko.heapDelMin();
        assertEquals(apu.getPaino(), 1);
    }
    
    @Test
    public void testaaKekoEhto2(){
        keko.heapInsert(testi4);
        keko.heapInsert(testi3);
        keko.heapInsert(testi2);
        keko.heapInsert(testi1);
        Verkkosolmu apu = keko.heapDelMin();
        assertEquals(apu.getPaino(), 1);
    }
    
    @Test
    public void testaaKekoEhto3(){
        keko.heapInsert(testi2);
        keko.heapInsert(testi3);
        keko.heapInsert(testi1);
        keko.heapInsert(testi4);
        Verkkosolmu apu = keko.heapDelMin();
        assertEquals(apu.getPaino(), 1);
    }
    
    @Test
    public void testaaKekoEhto4(){
        keko.heapInsert(testi4);
        keko.heapInsert(testi3);
        keko.heapInsert(testi2);
        keko.heapInsert(testi1);
        int i = 1;
        Verkkosolmu apu;
        while(!keko.empty()){
            apu = keko.heapDelMin();
            assertEquals(apu.getPaino(), i);
            i++;
        }
    }
    
}
