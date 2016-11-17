<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<% JumsHelper jh=JumsHelper.getInstance(); %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb=(UserDataBeans)session.getAttribute("udb");
    if(udb==null){
        udb=new UserDataBeans();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <!--Task5-->
        <input type="text" name="name" value="<%=udb.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="0">----</option>
            <%//デフォルト値を０にする(０の場合、空白文字をパースする際コンパイルエラーになる)
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%=jh.checkT5Selected(i,Integer.parseInt(udb.getYear()))%>> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="0">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <%=jh.checkT5Selected(i,Integer.parseInt(udb.getMonth()))%>> <%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="0">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <%=jh.checkT5Selected(i,Integer.parseInt(udb.getDay()))%>> <%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%=jh.checkT5Checked("1", udb.getType())%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%=jh.checkT5Checked("2", udb.getType())%>>営業<br>
        <input type="radio" name="type" value="3" <%=jh.checkT5Checked("3", udb.getType())%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udb.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.getComment()%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
