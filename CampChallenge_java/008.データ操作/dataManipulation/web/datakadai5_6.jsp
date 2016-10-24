<%-- 
    Document   : datakadai5_6
    Created on : 2016/10/19, 19:45:05
    Author     : Y.Sasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="datakadai5_6.jsp" method="post">
             名前<input type="text" name="txtName"><br>
             性別 男性<input type="radio" name="rdo" value="M">女性<input type="radio" name="rdo" value="F"><br>
             趣味<textarea name="mulTxt"></textarea><br>
             <input type="submit" value="送信">
         </form>
        <%
            request.setCharacterEncoding("UTF-8");
            String txtName = request.getParameter("txtName");
            String rdo = request.getParameter("rdo");
            String mulTxt = request.getParameter("mulTxt");
            
            Cookie cookie1=new Cookie("txtName",txtName);
            Cookie cookie2=new Cookie("rdo",rdo);
            Cookie cookie3=new Cookie("mulTxt",mulTxt);
            
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);
            
            Cookie cs1[] = request.getCookies();
            if (cs1 != null) {
                for (int i=0; i<cs1.length; i++) {
                    if (cs1[i].getName().equals("txtName")) {
                        out.print("前回の入力:<br>"+cs1[i].getValue()+"<br>");
                    }
                     if (cs1[i].getName().equals("rdo")) {
                        out.print(cs1[i].getValue()+"<br>");
                    }
                      if (cs1[i].getName().equals("mulTxt")) {
                        out.print(cs1[i].getValue()+"<br>");
                        break;
                    }
                }
            }
            %>
    </body>
</html>
