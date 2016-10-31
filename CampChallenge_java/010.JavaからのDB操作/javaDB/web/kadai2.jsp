<%-- 
    Document   : accessDB(kadai2)
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
        db_st=db_con.prepareStatement("insert into profiles value(6,'名無 権兵衛','000-0000-0000',40,'1984-01-01')");
        db_st.executeUpdate();
        out.print("レコードを追加しました。<br>");
        db_st=db_con.prepareStatement("select * from profiles where profilesID=6");
        ResultSet db_rs=db_st.executeQuery();
        while(db_rs.next()){
            out.print(db_rs.getString("name"));
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
