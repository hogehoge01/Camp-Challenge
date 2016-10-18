    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyoujunclassouyou;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Y.Sasa
 */
public class Hyoujunclassouyou {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File log=new File("C:\\Users\\Y.Sasa\\Documents\\testfolder\\classouyou.txt");
        FileWriter logWriter;
        try {
            logWriter = new FileWriter(log,true);
            Calendar cal=Calendar.getInstance();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月DD日HH時:mm分:ss秒");
            logWriter.write("開始:"+sdf.format(cal.getTime())+"\r\n");
            Scanner scanner=new Scanner(System.in);
            System.out.print("Input your name:");
            String name=scanner.next();
            System.out.println("Your name is "+name+".");
            logWriter.write("終了:"+sdf.format(cal.getTime())+"\r\n");
            logWriter.close();
            FileReader logReader=new FileReader(log);
            BufferedReader br=new BufferedReader(logReader);
            String str;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Hyoujunclassouyou.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
