/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Tietorakenteet.Verkkogeneraattori;
import Algoritmit.AStar;
import Algoritmit.BellmanFord;
import Algoritmit.Dijkstra;
import Tietorakenteet.*;

/**
 * Main-luokka. Aloittaa ohjelman.
 * @author Krisu
 */
public class Main {
    
    public static void main(String[] args){
        Vertailija vert = new Vertailija();
        vert.aloita();
    }
}
