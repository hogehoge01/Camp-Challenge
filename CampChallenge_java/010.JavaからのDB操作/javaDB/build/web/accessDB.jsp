<%-- 
    Document   : accessDB(kadai1)
    Created on : 2016/10/31, 10:42:24
    Author     : Y.Sasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
    Connection db_con=null;
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","Yudai","pass");
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
