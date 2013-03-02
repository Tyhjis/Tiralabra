/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Algoritmit.AStar;
import Algoritmit.BellmanFord;
import Algoritmit.Dijkstra;
import Tietorakenteet.Pino;

/**
 *
 * @author Krisu
 */
public class Vertailija {
    
    private Kello ajastin;
    private Pino polku;
    private AStar astar;
    private Dijkstra dijkstra;
    private BellmanFord bman;
            
    public Vertailija(){
        ajastin = new Kello();
    }
    
    
}
