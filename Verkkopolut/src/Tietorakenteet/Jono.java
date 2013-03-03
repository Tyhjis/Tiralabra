/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 * Jono. Hyödynnetään tässä projektissa Bellman-Fordin algoritmissa.
 * @author Krisu
 */
public class Jono {
    
    private Jonosolmu head;
    private Jonosolmu tail;
    
    public Jono(){
        head = null;
        tail = null;
    }
    /**
     * Kertoo, onko jono tyhjä.
     * @return Palauttaa true, jos jono on tyhjä.
     */
    public boolean isEmpty(){
        return head == null;
    }
    /**
     * Palauttaa Jonosolmun sisältämät koordinaatit.
     * @return Kokonaislukutaulukko. Sisältää koordinaatit järjestyksessä (rivi, sarake).
     */
    public int[] dequeue(){
        int[] sij = head.getSijainti();
        head = head.getNext();
        return sij;
    }
    /**
     * Luo ja lisää uuden Jonosolmu-olion.
     * @param i Verkon rivin koordinaatti.
     * @param j Verkon sarakkeen koordinaatti.
     */
    public void queue(int i, int j){
        if(isEmpty()){
            head = new Jonosolmu(i, j);
            tail = head;
        }
        else{
            tail.setNext(new Jonosolmu(i, j));
            tail = tail.getNext();
        }
    }
}
