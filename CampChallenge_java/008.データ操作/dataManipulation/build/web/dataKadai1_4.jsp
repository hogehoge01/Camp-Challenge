<%--
    Document   : dataKadai1_4
    Created on : 2016/10/19, 12:58:45
    Author     : Y.Sasa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--課題１--%>
         <form action="dataKadai1_4.jsp" method="post">
             名前<input type="text" name="txtName"><br>
             性別 男性<input type="radio" name="rdo" value="男性">女性<input type="radio" name="rdo" value="女性"><br>
             趣味<textarea name="mulTxt"></textarea><br>
             <input type="submit" value="送信">
         </form>
         <br>
        <%--課題２--%>
        <%
            request.setCharacterEncoding("UTF-8");
            String txtName = request.getParameter("txtName");
            String rdo = request.getParameter("rdo");
            String mulTxt = request.getParameter("mulTxt");
            //kadai2
            if(txtName!=""&&txtName!=null){
                out.print("名前 "+txtName+"<br>");
            }else{
                out.print("＊名前を入力してください"+"<br>");
            }
            if(rdo!=null&&rdo!=null){
                out.print("性別 "+rdo+"<br>");
            }else{
                out.print("＊性別にチェックを入れてください"+"<br>");
            }
            if(mulTxt!=""&&mulTxt!=null){
                out.print("趣味 "+mulTxt+"<br>");
            }else{
                out.print("＊趣味を入力してください"+"<br>");
            }
        %>
        <br>
        <%--課題３_Cookie--%>
        <%
            //初回の訪問
            Date currentTime=new Date();
            Cookie cookie=new Cookie("lastAccessC",currentTime.toString());
            response.addCookie(cookie);
            //次の訪問
            Cookie cs[] = request.getCookies();
            if (cs != null) {
                for (int i=0; i<cs.length; i++) {
                    if (cs[i].getName().equals("lastAccessC")) {
                        out.print("最後のログインは、"+cs[i].getValue()+"です。(Cookie)");
                        break;
                    }
                }
            }

        %>
        <br>
        <%--課題３_Session--%>
        <%
            //初回の訪問
            HttpSession hs=request.getSession(true);
            if(hs.getAttribute("lastAccessS")==null){
                out.print("Sessionはnullです");
            }else{
                out.print("最後のログインは、"+hs.getAttribute("lastAccessS")+"です。(Session)");
            }
            hs.setAttribute("lastAccessS",currentTime.toString());
        %>
    </body>
</html>
