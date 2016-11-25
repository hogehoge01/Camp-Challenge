
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("rd");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    <!--11/24/10:30~10:33--Problem.no10/削除した内容を見られるようにした-->
    <!--11/24/14:30~14:35--Problem.no16/deleteresult.jspも作成-->
    名前:<%= udd.getName()%><br>
    生年月日:<%= udd.getBirthday()%><br>
    種別:<%= udd.getType()%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br>
    以下の内容を削除しました。<br>
     <%=jh.home()%>
    </body>
</html>
