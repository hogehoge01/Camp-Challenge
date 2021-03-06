package org.mypackage.sample;
import java.util.*;
/**
 *
 * @author Y.Sasa
 */
public class java3kadai8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inputProfile(ID)
        Integer limit=2;
        int c=0;
        for(Map.Entry<Integer,ArrayList<String>>i:inputProfile().entrySet()){
            for(String j:i.getValue()){
                if(j==null){
                    continue;
                }
                System.out.println(j);
            }
            c++;//カウントループ終わり
            if(c==limit){
                break;
            }
            
        }
    }
    public static HashMap<Integer,ArrayList<String>> inputProfile(){
        //1st Person
        ArrayList<String>AL1=new ArrayList<String>();
        AL1.add("ichiro");
        AL1.add("19111111");
        AL1.add("Tokyo");
        HashMap<Integer,ArrayList<String>>HM=new HashMap<Integer,ArrayList<String>>();
        HM.put(1,AL1);
        //2nd Person
        ArrayList<String>AL2=new ArrayList<String>();
        AL2.add("Jiro");
        AL2.add("19221222");
        AL2.add(null);
        HM.put(2,AL2);
        //3rd Person
        ArrayList<String>AL3=new ArrayList<String>();
        AL3.add("Saburo");
        AL3.add("19330303");
        AL3.add("Saitama");
        HM.put(3,AL3);
        return HM;
    }
    
}