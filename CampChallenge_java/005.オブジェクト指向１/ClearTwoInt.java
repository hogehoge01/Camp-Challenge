/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

/**
 *
 * @author Y.Sasa
 */
public class ClearTwoInt extends TwoInt{
    ClearTwoInt(int a,int b){
        super(a,b);
    }
    public int ClearIntA(){
        return a=0;
    }
    public int ClearIntB(){
        return b=0;
    }
}
