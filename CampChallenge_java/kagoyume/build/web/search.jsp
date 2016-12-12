<%-- 
    Document   : search
    Created on : 2016/12/07, 13:47:59
    Author     : Y.Sasa
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="javaBeans.ItemDataBeans"%>
<%@page import="kagoyume.JumsHelper"%>
<%@page import="base.YahooAPIManager"%>
<% ArrayList<ItemDataBeans> items=(ArrayList<ItemDataBeans>)session.getAttribute("idb");
   boolean searchIsEmpty=(Boolean)request.getAttribute("searchIsEmpty");
   int total=0;
   String search="";
   if(!searchIsEmpty){
       total=(Integer)request.getAttribute("total");
       search=(String)request.getAttribute("search");
   }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include><jsp:include page="searchForm.jsp"></jsp:include>
        <%
            if(searchIsEmpty){
                out.print("キーワードを入力してください。<br>");
            }else{%>
            検索キーワード:<%=search%><br>
            検索結果:<%=total%>件<br>
        <table>
            <tr>
                <th>商品画像</th>
                <th>商品名</th>
                <th>価格</th>
             </tr>
        <%for(ItemDataBeans val:items){%>
                <tr>
                    <td><img src="<%=val.getItemImage()%>"></td>
                    <td><%=val.getItemName()%></td>
                    <td><%=val.getItemPrice()+"円"%></td>
                </tr>
        <%}%>
        </table>
            <%}%>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
