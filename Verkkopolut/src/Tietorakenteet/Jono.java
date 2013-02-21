/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Krisu
 */
public class Jono {
    
    private Jonosolmu head;
    private Jonosolmu tail;
    
    public Jono(){
        head = null;
        tail = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int[] dequeue(){
        int[] sij = head.getSijainti();
        head = head.getNext();
        return sij;
    }
    
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
