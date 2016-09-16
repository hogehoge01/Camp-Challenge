<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

//課題1
out.print("Hello world.<br>");

//課題2
out.print("groove"+"-"+"gear<br>");

//課題3
out.print("My Github Profile is <a href=\"https://github.com/hogehoge01\">here</a><br>");

//課題4,5
final int num1=460;
out.print((num1+150)+"<br>");
out.print((1000-num1)+"<br>");
out.print((num1*10)+"<br>");
out.print((num1/20)+"<br>"+"<br>");
	int num2=1500;
	out.print((++num2+1500)+"<br>");	//(1+1500)+1500(++num2が処理)
	out.print((num2++-1500)+"<br>");	//(1500+1)-1500
	out.print((num2*100)+"<br>");			//(1501+1)*100	(num2++の処理)
	out.print((num2/100)+"<br>");			//1502/100
	out.print((num2%100)+"<br>"+"<br>");	//...2

//課題6
int num3=1;
if(num3==1){
out.print("１です！");
}
if(num3==2){
out.print("プログラミングキャンプ！");
}
else{
out.print("その他です！");
}

	num3=2;
	if(num3==1){
	out.print("１です！");
	}
	if(num3==2){
	out.print("プログラミングキャンプ！");
	}
	else{
	out.print("その他です！");
	}

		num3=10;
		if(num3==1){
		out.print("１です！");
		}
		if(num3==2){
		out.print("プログラミングキャンプ！");
		}
		else{
		out.print("その他です！");
		}

%>
