package kagoyume;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaBeans.UserDataDTO;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            //DBに接続
            con = DBManager.getConnection();
            
            //SQL文（DTO→SQL）
            st =  con.prepareStatement("INSERT INTO user_t(name,password,mail,adress) VALUES(?,?,?,?)");
            st.setString(1,ud.getUserName());
            st.setString(2,ud.getPassword());
            st.setString(3,ud.getMailAddress());
            st.setString(4,ud.getAdress());
            
            //SQLに送信
            st.executeUpdate();
            
            st.close();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public boolean checkMail(String mail)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            //DBに接続
            con = DBManager.getConnection();
            //SQL文
            st =  con.prepareStatement("SELECT mail FROM user_t WHERE mail=?");
            st.setString(1,mail);
            //SQLに送信
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                st.close();
                return true;
            }else{
                st.close();
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public boolean checkPassword(String password)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            //DBに接続
            con = DBManager.getConnection();
            //SQL文
            st =  con.prepareStatement("SELECT password FROM user_t WHERE password=?");
            st.setString(1,password);
            //SQLに送信
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                st.close();
                return true;
            }else{
                st.close();
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
}
