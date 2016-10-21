/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Y.Sasa
 */
public class Dealer extends Human {
    ArrayList<Integer> cards=new ArrayList<Integer>();
    public Dealer(){
        for(int i=0;i<4;i++){
            for(int cardNum=1;cardNum<=13;cardNum++){
                cards.add(cardNum);
            }
        }
        Collections.shuffle(cards);
    }
    
    public ArrayList<Integer> deal(){
        ArrayList j=new ArrayList<Integer>();
        for(int i=0;i<2;i++){
            j.add(cards.get(0));
            cards.remove(0);
        }
        return j;
    }
    
    public ArrayList<Integer> hit(){
        ArrayList j=new ArrayList<Integer>();
        j.add(cards.get(0));
        cards.remove(0);
        return j;
    }
    
    @Override
    public boolean checkSum() {
        int j=0;
        for(int i=0;i<myCards.size();i++){
            j=j+myCards.get(i);
        }
        if(j<17){
            return true;
        }else{
            return false;
        }
    }
}