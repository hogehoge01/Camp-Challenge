<%-- 
    Document   : top
    Created on : 2016/12/05, 12:52:55
    Author     : Y.Sasa
--%>
<%
    String  loginMessage =(String)request.getAttribute("message");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kagoyume.LoginCheck"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめトップ</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="searchForm.jsp"></jsp:include>
        <%--ログインを実装--%>
        ショッピングサイトを使っている時、こんな経験ありませんか？　「あれいいな」「これいいな」「あっ、関連商品のこれもいい」「20%オフセールだって！？　買わなきゃ！」・・・そしていざ『買い物
        かご』を開いたとき、その合計金額に愕然とします。「こんなに買ってたのか・・・しょうがない。いくつか減らそう・・・」
        仕方がありません。無駄遣いは厳禁です。でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？　できればお金の事なんか考えずに好きなだけ買い物がしたい・・・。このサービス
        は、そんなフラストレーションを解消するために生まれた『金銭取引が絶対に発生しない』『いくらでも、どんなものでも購入できる(気分になれる)』『ECサイト』です。
        <%=loginMessage%>
    </body>
</html>
