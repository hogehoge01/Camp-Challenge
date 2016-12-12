<%-- 
    Document   : registrationconfirm
    Created on : 2016/12/05, 15:30:10
    Author     : Y.Sasa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="kagoyume.JumsHelper" %>
<%@page import="javaBeans.UserDataBeans" %>
<%
    UserDataBeans udb=(UserDataBeans)session.getAttribute("udb");
    ArrayList<String> chkList=udb.chkProperties();
    JumsHelper jh=new JumsHelper();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認画面</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <% if(chkList.size()==0){ %>
        <h1>登録確認</h1>
        ユーザー名:<%=udb.getUserName()%><br>
        パスワード:<%=udb.getPassword()%><br>
        メールアドレス:<%=udb.getMailAddress()%><br>
        住所:<%=udb.getAddress()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="RegistrationComplete" method="POST">
            <input type="submit" name="yes" value="はい">
            <%--セッションから不正アクセスチェック用整数を取得--%>
            <input type="hidden" name="ac" value="<%= session.getAttribute("ac")%>">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkInput(chkList) %>
    <% } %>
        <form action="Registration" method="POST">
            <input type="submit" name="no" value="登録画面に戻る"><br>
            <%--セッションから不正アクセスチェック用整数を取得--%>
            <input type="hidden" name="ac" value="<%= session.getAttribute("ac")%>">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
        <%=jh.home()%>
    </body>
</html>
