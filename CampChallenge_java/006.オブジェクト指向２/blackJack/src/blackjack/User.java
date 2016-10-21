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
public class User extends Human {
    @Override
    public boolean checkSum() {
        int j=0;
        for(int i=0;i<myCards.size();i++){
            j=j+myCards.get(i);
        }
        if(j<14){
            return true;
        }else{
            return false;
        }
    }
}
