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
            JB jb8=(JB)request.getAttribute("JB8");
            JB jb9=(JB)request.getAttribute("JB9");
            JB jb10=(JB)request.getAttribute("JB10");
            JB jb11=(JB)request.getAttribute("JB11");
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データベース検索</title>
    </head>
    <body>
        <h3>課題８</h3>
        <form action="kadaiC" method="post">
            名前・部分一致検索
            <input type="search" name="k8">
            <button type="submit" name="8IsntEmpty">検索</button><br>
        </form>
        <%
            if(jb8!=null){
                out.print(jb8.getResult()+"<br>");
            }
            %>
        
        <h3>課題９(profilesID欄は記入必須、INSERT)</h3>
        <form action="kadaiC" method="post">
        <table>
            <tr>
                <td>profilesID</td>
                <td><input type="text" name="profilesID"></td>
            </tr>
            <tr>
                <td>name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>tell</td>
                <td><input type="text" name="tell"></td>
            </tr>
            <tr>
                <td>age</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td>birthday</td>
                <td><input type="text" name="birthday"></td>
            </tr>
        </table>
            <br>
            <button type="submit" name="9IsntEmpty">DBに挿入</button>         
        </form>
        <%
            if(jb9!=null){
                out.print(jb9.getResult()+"<br>");
            }
            %>
        <h3>課題１０</h3>
        <form action="kadaiC" method="post">
            profiesIDを指定してそのレコードを削除<br>
            <input type="search" name="k10">
            <button type="submit" name="10IsntEmpty">削除</button><br>
        </form>
        <%
            if(jb10!=null){
                out.print(jb10.getResult()+"<br>");
            }
            %>
        <h3>課題１１(profilesID欄は記入必須、UPDATE)</h3>
        <form action="kadaiC" method="post">
        <table>
            <tr>
                <td>profilesID</td>
                <td><input type="text" name="profilesID"></td>
            </tr>
            <tr>
                <td>name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>tell</td>
                <td><input type="text" name="tell"></td>
            </tr>
            <tr>
                <td>age</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td>birthday</td>
                <td><input type="text" name="birthday"></td>
            </tr>
        </table>
            <br>
            <button type="submit" name="11IsntEmpty">DBを更新</button>         
        </form>
        <%
            if(jb11!=null){
                out.print(jb11.getResult()+"<br>");
            }
            %>
    </body>
</html>
