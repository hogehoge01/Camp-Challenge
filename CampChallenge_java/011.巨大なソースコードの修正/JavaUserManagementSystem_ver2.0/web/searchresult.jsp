<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.util.ArrayList"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <!--11/21/14:34~13:36Problem.no3/複合検索の修正及び実装-->
        <% for(UserDataDTO uddList:udd){%>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <tr>
                <!--11/21/13:05~14:41Problem.no3/複合検索の修正及び実装-->
                <td><a href="ResultDetail?id=<%= uddList.getUserID()%>"><%=uddList.getName()%></a></td>
                <td><%= uddList.getBirthday()%></td>
                <td><%= jh.exTypenum(uddList.getType())%></td>
                <td><%= uddList.getNewDate()%></td>
            </tr>
        </table>
        <% }%>
        <%=jh.home()%>
    </body>
</html>
