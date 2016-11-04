package kadai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Y.Sasa
 */
public class kadaiM {
    public void accessDB(){
        Connection dbConnect=null;
        PreparedStatement dbStatement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
        }catch(SQLException e_sql){
            System.out.println("Error"+e_sql.toString());
        }
        catch(Exception e){
            System.out.println("Error"+e.toString());
        }finally{
            if(dbConnect!=null){
                try{
                    dbConnect.close();
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
        }
    }
    public static String kadai8(String s){
        Connection dbConnect=null;
        PreparedStatement dbStatement=null;
        String result="";
        try{
            if(s.isEmpty()){
                return "検索フォームが空です";
            }else{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dbConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
                dbStatement=dbConnect.prepareStatement("select * from profiles where name like ?");
                dbStatement.setString(1,"%"+s+"%");
                ResultSet dbResultSet=dbStatement.executeQuery();
                result=toStringData(dbResultSet);
                dbStatement.close();
                dbConnect.close();
                if(result.isEmpty()){
                    result="一致無し";
                }
            }
        }catch(SQLException e_sql){
            System.out.println("Error"+e_sql.toString());
        }
        catch(Exception e){
            System.out.println("Error"+e.toString());
        }finally{
            if(dbConnect!=null){
                try{
                    dbConnect.close();
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
        }
        return result;
    }
    private static String toStringData(ResultSet rs) throws SQLException{
        String result="";
        while(rs.next()){
            result=result+String.valueOf(rs.getInt("profilesID"));
            result=result+(rs.getString("name"));
            result=result+(rs.getString("tell"));
            result=result+String.valueOf(rs.getInt("age"));
            result=result+(rs.getString("birthday"));
        }
        return result;
    }
}