<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jums.JumsHelper"
import="jums.UserDataDTO"
import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //--11/22/16:35--Problem.no18/update.jspにセッションから値をセット
    UserDataDTO udd = (UserDataDTO)session.getAttribute("rd");
    HttpSession hs = request.getSession();
    
    SimpleDateFormat sdfYear=new SimpleDateFormat("yyyy");
    String year=sdfYear.format(udd.getBirthday());
    
    SimpleDateFormat sdfMonth=new SimpleDateFormat("MM");
    String month=sdfMonth.format(udd.getBirthday());
    
    SimpleDateFormat sdfDay=new SimpleDateFormat("dd");
    String day=sdfDay.format(udd.getBirthday());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name" value="<%=udd.getName()%>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"<% if(Integer.parseInt(year)==i){out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"<% if((Integer.parseInt(month))==i){out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<% if(Integer.parseInt(day)==i){out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(udd.getType()==i){out.print("checked=\"checked\"");}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udd.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udd.getComment()%></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="確認画面へ">
        <!--11/24/18:50/Problem.no1/不正アクセスチェックの実装-->
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
