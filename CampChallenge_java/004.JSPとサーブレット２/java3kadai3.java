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
public class java3kadai3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //引数をメソッドkadai3に渡す    
        kadai3(100);
    }
    //kadai3method
    public static void kadai3(int a,int b,boolean type){
        if(type){
            System.out.println(a*a*b*b);
        }else{
            System.out.println(a*b);
        }
    }
    public static void kadai3(int a,int b){
        kadai3(a,b,false);
    }
    public static void kadai3(int a){
        kadai3(a,5,false);
    }
}