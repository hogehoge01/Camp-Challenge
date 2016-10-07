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
public class TwoInt {
    //publicな２つの変数
    public int a;
    public int b;
    //２つの値をセットするpublicなメソッド
    TwoInt(int a,int d){
        this.a=a;
        this.b=d;
    }
    //２つの変数の中身をプリントするメソッド
    public void printTwoInt(){
        System.out.println(this.a);
        System.out.println(this.b);
    }
}