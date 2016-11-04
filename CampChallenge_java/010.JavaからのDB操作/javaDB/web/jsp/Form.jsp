<%-- 
    Document   : Form
    Created on : 2016/11/04, 11:14:01
    Author     : Y.Sasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="kadai.JB"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            JB jb=(JB)request.getAttribute("JB");
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データベース検索</title>
    </head>
    <body>
        <form action="kadaiC" method="post">
            名前・部分一致検索
            <input type="search" name="k8"><input type="submit" value="検索">
        </form>
        <%
            if(jb!=null){
                out.print(jb.getResult());
            }
            %>
    </body>
</html>
