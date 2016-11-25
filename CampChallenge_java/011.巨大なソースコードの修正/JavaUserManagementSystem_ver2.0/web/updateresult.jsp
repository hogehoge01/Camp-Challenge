<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="jums.UserDataBeans" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    //UserDataDTO udd = (UserDataDTO)request.getAttribute("rd");
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
    //UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
     ArrayList<String> chkList = (ArrayList<String>)request.getAttribute("chkList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <!--11/24/19:44--Problem.no22/updateresultの実装-->
        <% if(chkList.size()==0){ %>
        <h1>変更結果</h1><br>
        以上の内容で登録しました。<br>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList) %>
        <a href="Update">入力画面へ戻る</a><br>
        <% } %>
    <!--11/24/19:44--Problem.no20/</body>が一つ多かったので削除-->
    </body>
    <%=jh.home()%>
</html>
