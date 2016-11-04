package kadai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
/**
 *
 * @author Y.Sasa
 */
public class JB implements Serializable{
    private String result;
    public JB(){
    }
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result=result;
    }
}
