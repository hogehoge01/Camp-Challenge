<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

//課題：応用編

//http://localhost:8080/camp/sample.jsp?total=&quantity=&productType=
//(例)http://localhost:8080/camp/kadai7.jsp?total=8000&quantity=5&productType=1

String reqA=request.getParameter("total");
String reqB=request.getParameter("quantity");
String reqC=request.getParameter("productType");

//課題7-1
int numC=Integer.parseInt(reqC);
if(numC==1){
out.print("雑貨"+"<br>");
}
if(numC==2){
out.print("生鮮食品"+"<br>");
}
if(numC==3){
out.print("その他"+"<br>");
}

//課題7-2
out.print("総額:"+reqA+"円"+"<br>");
int numA=Integer.parseInt(reqA);
int numB=Integer.parseInt(reqB);
out.print("1個当たり"+numA/numB+"円"+"<br>");

//課題7-3
if(numA<3000){
out.print(0+"ポイント");
}
else if(numA>=3000&&numA<5000){
out.print(numA*0.04+"ポイント");
}
else{
out.print(numA*0.05+"ポイント");
}

%>
