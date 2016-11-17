package jums;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラスです。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    //Task5 selected属性のチェック
    public String checkT5Selected(int a,int b){
        if(a==b){
            return "selected";
        }else{
            return "";
        }
    }
    //Task5 checked属性のチェック
    public String checkT5Checked(String a,String b){
        if(a.equals(b)){
            return "checked";
        }else{
            return "";
        }
    }
}
