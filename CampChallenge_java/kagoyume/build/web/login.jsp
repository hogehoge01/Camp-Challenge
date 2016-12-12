<%-- 
    Document   : login
    Created on : 2016/12/05, 13:08:26
    Author     : Y.Sasa
--%>
<%@page import="kagoyume.JumsHelper"%>
<%
    JumsHelper jh=new JumsHelper();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h3>ログイン</h3>
        <form action="LoginCheck" method="POST">メールアドレス<input type="text" name="mailAddress"><br>
        パスワード<input type="text" name="password"><br>
        <input type="submit" name="login" value="ログイン"></form><br>
        <%=jh.home()%>
    </body>
</html>
