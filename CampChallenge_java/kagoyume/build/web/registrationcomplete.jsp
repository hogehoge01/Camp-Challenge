<%-- 
    Document   : registrationcomplete
    Created on : 2016/12/06, 11:10:52
    Author     : Y.Sasa
--%>

<%@page import="javaBeans.UserDataBeans"
import="kagoyume.JumsHelper"%>
<%
    UserDataBeans udb =(UserDataBeans)request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        ユーザー名:<%=udb.getUserName()%><br>
        パスワード:<%=udb.getPassword()%><br>
        メールアドレス:<%=udb.getPassword()%><br>
        住所:<%= udb.getAddress()%><br>
        以上の内容で登録しました。<br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
