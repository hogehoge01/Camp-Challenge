<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("rd");
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    <!--11/24/10:20~10:20--Problem.no6/brタグを用いて見やすく修正-->
    <!--11/24/12:04~10:04--Problem.no12/セッションから情報を取り出し表示-->
    以下の内容を削除します。よろしいですか？<br>    
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= jh.exTypenum(udd.getType())%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
    <form action="DeleteResult" method="POST">
        <!--11/24/10:23~10:23--Problem.no7/inputタグの誤字styleの前にスペースを入力して修正-->
        <input type="submit" name="YES" value="はい" style="width:125px">
        <!--11/24/18:50/Problem.no1/不正アクセスチェックの実装-->
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
        <!--11/24/15:03--Problem.no17/いいえを押した際UserIDをクエストリングに渡す修正-->
    <form action="ResultDetail?id=<%=udd.getUserID()%>" method="POST">
        <!--11/24/10:37~10:42--Problem.no9/brタグを用いて見やすく修正、詳細画面に戻るからいいえを追加、inputタグの幅を125pxに変更-->
        <input type="submit" name="NO" value="いいえ(詳細画面へ)" style="width:125px">
        <!--11/24/18:50/Problem.no1/不正アクセスチェックの実装-->
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
    <!--11/24/10:30~10:33--Problem.no8/TOPへ戻るを追加-->
    <%=jh.home()%>
    </body>
</html>
