package kagoyume;

import java.util.ArrayList;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkInput(ArrayList<String> chkList){
        String output = "";
        for(String val:chkList){
                if(val.equals("userName")){
                    output+="ユーザー名";
                }
                if(val.equals("password")){
                    output+="パスワード";
                }
                if(val.equals("mailAddress")){
                    output+="メールアドレス";
                }
                if(val.equals("address")){
                    output+="住所";
                }
                output+="が未記入です<br>";
            }
        return output;
    }
    
}
