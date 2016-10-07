/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyoujunclass;
import java.util.*;
import java.text.*;
/**
 *
 * @author Y.Sasa
 */
public class Hyoujunclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //kadai1
        Calendar cal=Calendar.getInstance();
        cal.set(2016,1,1,0,00,00);
        Date calpast=cal.getTime();
        System.out.println(calpast.getTime());
        //kadai2
        Calendar cal2=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");
        System.out.println(sdf.format(cal2.getTime()));
        //kadai3
        Calendar cal3=Calendar.getInstance();
        cal3.set(2015,12,31,23,59,59);
        Date calpast3=cal3.getTime();
        int i=Integer.parseInt(Date calpast3);
        Integer.valueOf(Date calpast3);
    }
    
}
