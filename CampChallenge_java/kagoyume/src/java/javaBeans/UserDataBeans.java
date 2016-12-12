package javaBeans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class UserDataBeans implements Serializable{
    String userName;
    String password;
    String mailAddress;
    String address;
    
    public UserDataBeans(){
        this.userName ="";
        this.password="";
        this.mailAddress="";
        this.address="";
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public ArrayList<String> chkProperties(){
    ArrayList<String> chkList = new ArrayList<String>();
    if(this.getUserName().equals("")){
        chkList.add("userName");
    }
    if(this.getPassword().equals("")){
        chkList.add("password");
    }
    if(this.getMailAddress().equals("")){
        chkList.add("mailAddress");
    }
    if(this.getAddress().equals("")){
        chkList.add("address");
    }
    return chkList;
}

    public void UD2DTOMapping(UserDataDTO udd){
        udd.setUserName(this.userName);
        udd.setPassword(this.password);
        udd.setMailAddress(this.mailAddress);
        udd.setAdress(this.address);
    }
}
