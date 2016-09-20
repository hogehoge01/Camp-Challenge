<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%

//課題7 soedaを表示
String[] names={"10","100","soeda","hayashi","-20","118","End"};
out.print(names[2]+"<br>");

//課題8 上書きされているか確認
names[2]="33";
out.print(names[2]+"<br>");

//課題9 便宜上連想配列を表示
HashMap<String,String>hMap=new HashMap<String,String>();
hMap.put("1","AAA");
hMap.put("hello","world");
hMap.put("soeda","33");
hMap.put("20","20");
for(Map.Entry<String,String>val:hMap.entrySet()){
	out.print(val.getKey());
	out.print("->");
	out.print(val.getValue()+"<br>");
}
%>