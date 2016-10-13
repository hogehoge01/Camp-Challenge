/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyoujunclass;
import java.nio.charset.Charset;
import java.util.*;
import java.text.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Calendar cal1=Calendar.getInstance();
        cal1.set(2016,1,1,0,00,00);
        Date calpast1=cal1.getTime();
        System.out.println(calpast1.getTime());
        //kadai2
        Calendar cal2=Calendar.getInstance();
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");
        System.out.println(sdf2.format(cal2.getTime()));
        //kadai3
        Calendar cal3=Calendar.getInstance();
        cal3.set(2016,11,4,10,00,00);
        SimpleDateFormat sdf3=new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");
        System.out.println(sdf3.format(cal3.getTime()));
        //kadai4
        Calendar cal4_1=Calendar.getInstance();
        Calendar cal4_2=Calendar.getInstance();
        cal4_1.set(2015,1,1,0,0,0);
        cal4_2.set(2015,12,31,23,59,59);
        long dif4=cal4_1.getTimeInMillis()-cal4_2.getTimeInMillis();
        //kadai5
        String myName="笹森 勇大";
        System.out.println("バイト数 "+myName.getBytes(Charset.forName("UTF-8")).length);
        System.out.println("文字数 "+myName.length());
        //kadai6
        String kadai6="gorogoroff@gmail.com";
        int num=kadai6.indexOf("@");
        System.out.println(kadai6.substring(num));
        //kadai7
        String kadai7="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        kadai7=kadai7.replace("I","い");
        kadai7=kadai7.replace("U","う");
        System.out.println(kadai7);
        //kadai8&9
        try {
            File kadai8=new File("C:\\Users\\Y.Sasa\\Documents\\testfolder\\testKadai8.txt");
            FileWriter fw8uwagaki;
            fw8uwagaki = new FileWriter(kadai8);
            fw8uwagaki.write("おはよう\r\nこんにちは\rこんばんは\nおやすみ");
            FileWriter fw8tuiki = new FileWriter(kadai8,true);
            fw8tuiki.write("\r\n朝ですね");
            fw8uwagaki.close();
            fw8tuiki.close();
            //kadai9
            FileReader fw8yomikomi=new FileReader(kadai8);
            BufferedReader br9=new BufferedReader(fw8yomikomi);
            String str;
            while((str=br9.readLine())!=null){
                System.out.println(str);
            }
            br9.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Hyoujunclass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
