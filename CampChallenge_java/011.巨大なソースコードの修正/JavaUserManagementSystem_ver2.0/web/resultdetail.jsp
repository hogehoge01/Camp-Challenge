<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //--11/24/11:46--リクエストスコープではなくセッションにとってきたresulDataを保管するように変更
    UserDataDTO udd = (UserDataDTO)session.getAttribute("rd");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        <!--11/22/16:48~17:02--Problem.no6-->
        種別:<%= jh.exTypenum(udd.getType())%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="Update" method="POST">
        <!--11/21/14:47~14:47--Problem.no4/inputタグの誤字styleの前にスペースを入力して修正-->
        <input type="submit" name="update" value="変更" style="width:100px">
        </form>
        <form action="Delete" method="POST">
        <input type="submit" name="delete" value="削除" style="width:100px">
        </form>
        <%=jh.home()%>
    </body>
</html>
