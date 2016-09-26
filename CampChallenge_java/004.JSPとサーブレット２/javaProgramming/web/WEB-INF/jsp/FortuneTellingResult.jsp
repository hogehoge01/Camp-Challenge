<%-- 
    Document   : FortuneTellingResult
    Created on : 2016/09/26, 14:23:34
    Author     : Y.Sasa
--%>

<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.sample.ResultData"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultData data=(ResultData)request.getAttribute("DATA");
         %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data !=null){
                out.print("<h1>あなたの"+data.getD()+"の運勢は、"+data.getLuck()+"です！</h1>");
            }
        %>
    </body>
</html>
