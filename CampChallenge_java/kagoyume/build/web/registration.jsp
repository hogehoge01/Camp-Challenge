<%-- 
    Document   : registration
    Created on : 2016/12/05, 13:33:20
    Author     : Y.Sasa
--%>
<%@page import="javaBeans.UserDataBeans"%>
<%@page import="kagoyume.JumsHelper"%>
<%
    UserDataBeans udb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserDataBeans)session.getAttribute("udb");
    }
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <form action="RegistrationConfirm" method="POST">
            <h3>入力フォーム</h3>
            ユーザー名<input type="text" name="userName" value="<%if(reinput){out.print(udb.getUserName());}%>"><br>
            パスワード<input type="text" name="password" value="<% if(reinput){out.print(udb.getPassword());}%>"><br>
            メールアドレス<input type="text" name="mailAddress" value="<% if(reinput){out.print(udb.getMailAddress());}%>"><br>
            住所<input type="text" name="address" value="<% if(reinput){out.print(udb.getAddress());}%>"><br>
            <input type="submit" name="submit" value="確認画面へ">
            <%--セッションから不正アクセスチェック用整数を取得--%>
            <input type="hidden" name="ac" value="<%= session.getAttribute("ac")%>">
        </form>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
