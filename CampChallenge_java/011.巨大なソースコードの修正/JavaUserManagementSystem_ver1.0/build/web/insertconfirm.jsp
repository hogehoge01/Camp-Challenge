<%@page import="javax.servlet.http.HttpSession" %>
<!--Task1-->
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb=(UserDataBeans)session.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <!--Task4-->
        <% boolean existEmpty=false; %>
        <% String confirm=""; %>
        <% 
           if(udb.getName().equals("")){
            confirm+="名前を入力してください<br>";
            existEmpty = true;
           }
           if(udb.getYear().equals("0")||udb.getMonth().equals("0")||udb.getDay().equals("0")){
            confirm+="生年月日を選択してください<br>";
            existEmpty = true;
           }
           if(udb.getTell().equals("")){
            confirm+="電話番号を入力してください<br>";
            existEmpty = true;
           }
           if(udb.getComment().equals("")){
            confirm+="自己紹介を記入してください<br>";
            existEmpty = true;
           }
        %>
        <% if(!existEmpty){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <!--Task2-->
            <input type="hidden" name="ac"  value="<%=hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h3><% out.print(confirm);%></h3>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <!--Task1-->
            <br>
            <%=JumsHelper.getInstance().home()%>
        </form>
    </body>
</html>
