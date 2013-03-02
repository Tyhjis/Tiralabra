/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Tietorakenteet.Pino;

/**
 *
 * @author Krisu
 */
public class Visualisoija {
    
    int[][] verkko;
    String[][] visualverkko;
    
    public Visualisoija(){
        
    }
    
    public void setVerkko(int[][] verkko){
        this.verkko = verkko;
        int pituus = verkko.length;
        this.visualverkko = new String[pituus][pituus];
        Integer n;
        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                n = new Integer(verkko[i][j]);
                visualverkko[i][j] = n.toString();
            }
        }
    }
    
    public void visualisoiPolut(Pino pino1, Pino pino2){
        if(this.verkko != null){
            int[] sij, sij2;
            Pino lol1 = pino1;
            Pino lol2 = pino2;
            int kokonaispaino1 = 0;
            int kokonaispaino2 = 0;
            System.out.println("Dijkstran pituus: "+lol1.getSize());
            System.out.println("A*:n pituus: "+lol2.getSize());
            if(lol1.getSize() == lol2.getSize()){
                while(!lol1.empty()){
                sij = lol1.pop();
                sij2 = lol2.pop();
                kokonaispaino1 = kokonaispaino1+this.verkko[sij[0]][sij[1]];
                kokonaispaino2 = kokonaispaino2+this.verkko[sij2[0]][sij2[1]];
                if(sij[0] == sij2[0] && sij[1] == sij2[1]){
                    this.visualverkko[sij[0]][sij[1]] = "B";
                }
                else{
                    this.visualverkko[sij[0]][sij[1]] = "D";
                    this.visualverkko[sij2[0]][sij2[1]] = "A";
                }
               }
                System.out.println("Dijkstran kokonaispaino: "+kokonaispaino1);
                System.out.println("A*:n kokonaispaino: "+kokonaispaino2);
            }
            else{
                visualisoiPolku(pino1, "D");
                visualisoiPolku(pino2, "A");
            }
        }
    }
    
    public void visualisoiPolku(Pino pino, String vis){
        Pino lol = pino;
        int[] sij;
        int kokonaispaino = 0;
        System.out.println("Pituus: "+lol.getSize());
        while(!lol.empty()){
            sij = lol.pop();
            kokonaispaino = kokonaispaino+verkko[sij[0]][sij[1]];
            this.visualverkko[sij[0]][sij[1]] = vis;
        }
        System.out.println(vis+":n kokonaispaino: "+kokonaispaino);
    }
    
    public void tulostaVerkko(){
        for (int i = 0; i < visualverkko.length; i++) {
            for (int j = 0; j < visualverkko.length; j++) {
                if(visualverkko[i][j].length() > 1){
                    System.out.print(visualverkko[i][j]+" ");
                }
                if(visualverkko[i][j].length() == 1){
                    System.out.print(visualverkko[i][j]+"  ");
                }
            }
            System.out.println("");
        }
    }
}
