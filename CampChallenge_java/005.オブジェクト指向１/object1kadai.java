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
public class object1kadai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //インスタンスを生成
        TwoInt AAA=new TwoInt(13,55);
        //プリントするメソッドを呼び出す
        AAA.printTwoInt();
        //ClearTwoIntを呼び出す
        ClearTwoInt BBB=new ClearTwoInt(0,0);
        BBB.ClearIntA();
        BBB.ClearIntB();
    }
    
}
