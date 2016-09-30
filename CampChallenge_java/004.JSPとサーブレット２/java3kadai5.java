/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;
import java.util.*;
/**
 *
 * @author Y.Sasa
 */
public class java3kadai5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        inputProfile(1,"Satoh","19640905","Tokyo");
        inputProfile(2,"Suzuki","19980328","Saitama");
        inputProfile(3,"Sasaki","19881220","Kanagawa");
    }
    public static void inputProfile(int id,String name,String birth,String adress){
        ArrayList<String> infoProfile=new ArrayList<String>();
        infoProfile.add(name);
        infoProfile.add(birth);
        infoProfile.add(adress);
        HashMap<Integer,ArrayList> hMap=new HashMap<Integer,ArrayList>();
        hMap.put(id,infoProfile);
        System.out.println(infoProfile.get(0));
        System.out.println(infoProfile.get(1));
        System.out.println(infoProfile.get(2));
    }
    
}