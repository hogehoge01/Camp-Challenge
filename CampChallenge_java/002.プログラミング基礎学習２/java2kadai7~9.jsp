<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

//課題7 soedaを表示
String[] names={"10","100","soeda","hayashi","-20","118","End"};
out.print(names[2]+"<br>");
//課題8 上書きされているか確認
names[2]="33";
out.print(names[2]+"<br>");

%>
