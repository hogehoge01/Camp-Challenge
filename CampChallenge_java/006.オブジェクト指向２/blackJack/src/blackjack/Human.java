/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author Y.Sasa
 */
public abstract class Human {
    protected ArrayList<Integer> myCards=new ArrayList<Integer>();
    public void setCard(ArrayList<Integer> j) {
        myCards.addAll(j);
    }
    public void checkSuit(){
        for(int i=0;i<myCards.size();i++){
            if(myCards.get(i)>10){
                myCards.set(i,10);
            }
        }
    }
    public void checkAce(){
        int l=0;
        for(int i=0;i<myCards.size();i++){
            l=l+myCards.get(i);
        }
        while(l<=11&&myCards.contains(1)){
            myCards.set(myCards.indexOf(1),11);
            l=l+10;
        }
    }
    public abstract boolean checkSum();
    public Integer open() {
        int j=0;
        for(int i=0;i<myCards.size();i++){
            j=j+myCards.get(i);
        }
        return j;
    }
    public boolean checkBust(){
        if(open()>21){
            return true;
        }else{
            return false;
        }
    }
}