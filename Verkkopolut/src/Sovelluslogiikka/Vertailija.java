/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Algoritmit.AStar;
import Algoritmit.BellmanFord;
import Algoritmit.Dijkstra;
import Tietorakenteet.Pino;
import Tietorakenteet.Verkkogeneraattori;
import Tietorakenteet.Verkot;
import java.util.Scanner;

/**
 *
 * @author Krisu
 */
public class Vertailija {
    
    private Kello ajastin;
    private AStar astar;
    private Dijkstra dijkstra;
    private BellmanFord bman;
    private Scanner input;
    
    public Vertailija(){
        ajastin = new Kello();
        astar = new AStar();
        dijkstra = new Dijkstra();
        bman = new BellmanFord();
        input = new Scanner(System.in);
    }
    
    public void aloita(){
        int koko = 0;
        boolean jatka = false;
        while(!jatka){
            System.out.println("Syötä haluamasi koko verkolle tai syötä 0, jos haluat lopettaa: ");
            koko = input.nextInt();
            try{
                Integer n = new Integer(koko);
                if(n.intValue() >= 10 && n.intValue() <= 500){
                    jatka = true;
                }
            }
            catch(NumberFormatException e){
                System.err.println(e);
            }
        }
        ajaAlgoritmit(koko);        
    }
    
    private void ajaAlgoritmit(int koko){
        Verkkogeneraattori verkkogen = new Verkkogeneraattori();
        Pino polku = new Pino();
        int[][] verkko = verkkogen.generoiLuolasto(koko, 0, 0, koko-1, koko-1);
        astar.setGraph(verkko);
        dijkstra.setGraph(verkko);
        bman.setGraph(verkko);
        //A*
        System.out.println("----------\nA*");
        ajastin.aloita();
        astar.algoritmi(0,0,koko-1,koko-1);
        ajastin.lopeta();
        System.out.println("A*:n aika: "+ajastin.getAika());
        polku = astar.getPolku(koko-1, koko-1);
        System.out.println("A*:n polun pituus: "+polku.getSize());
        System.out.println("----------");
        //Dijkstra
        System.out.println("DIJKSTRA");
        ajastin.aloita();
        dijkstra.algoritmi(0, 0);
        ajastin.lopeta();
        System.out.println("Dijkstran aika: "+ajastin.getAika());
        polku = dijkstra.getPolku(koko-1, koko-1);
        System.out.println("Dijkstran polun pituus: "+polku.getSize());
        System.out.println("----------");
        //Bellman-Ford
        System.out.println("BELLMAN-FORD");
        ajastin.aloita();
        bman.algoritmi(0, 0);
        ajastin.lopeta();
        System.out.println("Bellman-Fordin aika: "+ajastin.getAika());
        polku = bman.getPolku(koko-1, koko-1);
        System.out.println("Bellman-Fordin polun pituus: "+polku.getSize());
        System.exit(0);
    }
    
}
