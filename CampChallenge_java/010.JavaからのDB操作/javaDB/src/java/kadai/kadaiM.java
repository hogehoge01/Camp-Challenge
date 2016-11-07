package kadai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
/**
 *
 * @author Y.Sasa
 */
//例外のreturnの使い方は正しいか？
public class kadaiM {
    //ResultSet型変数rsを取り出し一行に連結させるメソッド
    private static String toStringData(ResultSet rs)throws SQLException{
        String result="";
        while(rs.next()){
            result=result+String.valueOf(rs.getInt("profilesID"))+" ";
            result=result+(rs.getString("name"))+" ";
            result=result+(rs.getString("tell"))+" ";
            result=result+String.valueOf(rs.getInt("age"))+" ";
            result=result+(rs.getString("birthday"))+"<br>";
        }
        return result;
    }
    public static String kadai8(String s){
        Connection dbConnect=null;
        PreparedStatement dbStatement=null;
        String result="";
        try{
            //仮引数の中身が無かった時の処理
            if(s.equals("")){
                return "課題８の検索フォームが空です";
            }else{
                //DBに接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dbConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
                //SELECT文を送信
                dbStatement=dbConnect.prepareStatement("select * from profiles where name like ?");
                dbStatement.setString(1,"%"+s+"%");
                ResultSet dbResultSet=dbStatement.executeQuery();
                //ResultSet型変数dbResultSetをtoStringメソッドで一行にまとめて変数resultに代入
                result=toStringData(dbResultSet);
                //Close
                dbStatement.close();
                dbConnect.close();
                //dbResultSetの中身が無かった時の処理
                if(result.equals("")){
                    result="一致無し";
                }
            }
        }catch(SQLException e_sql){
            result=result+"<br>Error_M8_q_sql "+e_sql.toString();
        }catch(Exception e){
            result=result+"<br>Error_M8_e "+e.toString();
        }finally{
            if(dbConnect!=null){
                try{
                    dbConnect.close();
                }catch(Exception e_con){
                    result=result+"<br>Error_M8_e_con "+e_con.getMessage();
                }
            }
        }
        return result;
    }
        public static String kadai9(String profilesID,String name,String tell,String age,String birthday){
        Connection dbConnect=null;
        PreparedStatement dbStatement=null;
        String result="";
        try{
            //DBに接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
            boolean existEmpty=false;
            //データ挿入フォームの記入漏れチェック
            if(profilesID.equals("")){
                result=result+"profilesIDを入力して下さい<br>";
                existEmpty = true;
            }
            if(name.equals("")){
                result=result+"nameを入力して下さい<br>";
                existEmpty = true;
            }
            if(tell.equals("")){
                result=result+"tellを入力して下さい<br>";
                existEmpty = true;
            }
            if(age.equals("")){
                result=result+"ageを入力して下さい<br>";
                existEmpty = true;
            }
            if(birthday.equals("")){
                result=result+"birthdayを入力して下さい<br>";
                existEmpty = true;
            }
            if(!existEmpty){
                //INSERT文を送信
                dbStatement=dbConnect.prepareStatement("insert into profiles values(?,?,?,?,?)");
                dbStatement.setInt(1,Integer.parseInt(profilesID));
                dbStatement.setString(2,name);
                dbStatement.setString(3,tell);
                dbStatement.setInt(4,Integer.parseInt(age));
                dbStatement.setString(5,birthday);
                dbStatement.executeUpdate();
                dbStatement.close();
                //SELECT文を送信
                dbStatement=dbConnect.prepareStatement("select * from profiles where profilesID=?");
                dbStatement.setInt(1,Integer.parseInt(profilesID));
                ResultSet dbResultSet=dbStatement.executeQuery();
                result=toStringData(dbResultSet)+"を挿入しました<br>";
                //Close
                dbStatement.close();
                dbConnect.close();
            }
        }catch(SQLException e_sql){
            result=result+"<br>Error_M9_q_sql "+e_sql.toString();
        }
        catch(Exception e){
            result=result+"<br>Error_M9_e "+e.toString();
        }finally{
            if(dbConnect!=null){
                try{
                    dbConnect.close();
                }catch(Exception e_con){
                    result=result+"<br>Error_M9_e_con "+e_con.getMessage();
                }
            }
        }
        return result;
    }
    public static String kadai10(String s){
        Connection dbConnect=null;
        PreparedStatement dbStatement=null;
        String result="";
        try{
            boolean existEmpty=false;
            if(s.equals("")){
                result="削除するレコードのProfilesIDを入力して下さい";
                existEmpty=true;
            }
            if(!existEmpty){
                //DBに接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dbConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
                //DELET文を送信
                dbStatement=dbConnect.prepareStatement("delete from profiles where profilesID=?");
                dbStatement.setInt(1,Integer.parseInt(s));
                //excuteUpdate()の戻り値を取得&SQLに送信
                int checkDelete=dbStatement.executeUpdate();
                //Close
                dbStatement.close();
                dbConnect.close();
                //excuteUpdate()の戻り値を元に判定
                if(checkDelete==0){
                    result="profilesID="+s+"は存在しません。"+checkDelete+"件削除しました。<br>";
                }else{
                    result="profilesID="+s+"のレコードを削除しました。"+checkDelete+"件削除しました。<br>";
                }
            }
        }catch(SQLException e_sql){
            result=result+"<br>Error_M10_q_sql "+e_sql.toString();
        }catch(Exception e){
            result=result+"<br>Error_M10_e "+e.toString();
        }finally{
            if(dbConnect!=null){
                try{
                    dbConnect.close();
                }catch(Exception e_con){
                    result=result+"<br>Error_M10_e_con"+e_con.getMessage();
                }
            }
        }
        return result;
    }
    public static String kadai11(String profilesID,String name,String tell,String age,String birthday){
        Connection dbConnect=null;
        PreparedStatement dbStatement=null;
        String result="";
        try{
            //DBに接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
            boolean existEmpty=false;
            //データ挿入フォームの記入漏れチェック
            if(profilesID.equals("")){
                result=result+"profilesIDを入力して下さい<br>";
            }else{
                //INSERT文を送信
                if(!name.equals("")){
                    dbStatement=dbConnect.prepareStatement("update profiles set name=? where profilesID=?");
                    dbStatement.setString(1,name);
                    dbStatement.setInt(2,Integer.parseInt(profilesID));
                    dbStatement.executeUpdate();
                    dbStatement.close();
                }
                if(!tell.equals("")){
                    dbStatement=dbConnect.prepareStatement("update profiles set tell=? where profilesID=?");
                    dbStatement.setString(1,tell);
                    dbStatement.setInt(2,Integer.parseInt(profilesID));
                    dbStatement.executeUpdate();
                    dbStatement.close();
                }
                if(!age.equals("")){
                    dbStatement=dbConnect.prepareStatement("update profiles set age=? where profilesID=?");
                    dbStatement.setInt(1,Integer.parseInt(age));
                    dbStatement.setInt(2,Integer.parseInt(profilesID));
                    dbStatement.executeUpdate();
                    dbStatement.close();
                }if(!birthday.equals("")){
                    dbStatement=dbConnect.prepareStatement("update profiles set birthday=? where profilesID=?");
                    dbStatement.setString(1,birthday);
                    dbStatement.setInt(2,Integer.parseInt(profilesID));
                    dbStatement.executeUpdate();
                    dbStatement.close();
                }
                //SELECT文を送信
                dbStatement=dbConnect.prepareStatement("select * from profiles where profilesID=?");
                dbStatement.setInt(1,Integer.parseInt(profilesID));
                ResultSet dbResultSet=dbStatement.executeQuery();
                //nullcheckを実装予定
                result="profilesID="+profilesID+"を更新し、<br>"+toStringData(dbResultSet)+"にしました<br>";
            //Close
                dbStatement.close();
                dbConnect.close();
            }
        }catch(SQLException e_sql){
            result=result+"<br>Error_M11_q_sql "+e_sql.toString();
        }
        catch(Exception e){
            result=result+"<br>Error_M11_e "+e.toString();
        }finally{
            if(dbConnect!=null){
                try{
                    dbConnect.close();
                }catch(Exception e_con){
                    result=result+"<br>Error_M11_e_con "+e_con.getMessage();
                }
            }
        }
        return result;
    }
}