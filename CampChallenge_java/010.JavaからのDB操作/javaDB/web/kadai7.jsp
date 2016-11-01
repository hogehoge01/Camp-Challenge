<%-- 
    Document   : accessDB(kadai7)
    Created on : 2016/10/31, 10:42:24
    Author     : Y.Sasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
    Connection db_con=null;
    PreparedStatement db_st=null;
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
        db_st=db_con.prepareStatement("update profiles set name=?,age=?,birthday=? where profilesID=?");
        db_st.setString(1,"松岡 修造");
        db_st.setInt(2,48);
        db_st.setString(3,"1967-11-06");
        db_st.setInt(4,1);
        db_st.executeUpdate();
        db_st=db_con.prepareStatement("select * from profiles");
        ResultSet db_rs=db_st.executeQuery();
        boolean nullCheck=false;
        while(db_rs.next()){
            out.print(db_rs.getInt("profilesID"));
            out.print(" ");
            out.print(db_rs.getString("name")+" ");
            out.print(db_rs.getString("tell"));
            out.print(db_rs.getInt("age"));
            out.print(db_rs.getString("birthday"));
            out.print("<br>");
            nullCheck=true;
        }
        if(!nullCheck){
            out.print("レコードがありません<br>");
        }
        db_st.close();
        db_con.close();
    }catch(SQLException e_sql){
        out.print("Error"+e_sql.toString());
    }catch(Exception e){
        out.print("Error"+e.toString());
    }finally{
    if(db_con!=null){
        try{
            db_con.close();
        }catch(Exception e_con){
            out.print(e_con.getMessage());
        }
    }
}
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
