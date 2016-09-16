<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

//課題3 回数と計算結果を表示
long num1=8;
for(int i=1;i<=20;i++){
out.print(i+"回目で"+(num1=num1*8)+"<br>");
}

//課題4 結果を表示
for(int i=1;i<=30;i++){
out.print("A");
}
out.print("<br>");

//課題5 
int num2=0;
for(int i=0;i<=100;i++){
num2+=i;
}
out.print(num2);

%>
