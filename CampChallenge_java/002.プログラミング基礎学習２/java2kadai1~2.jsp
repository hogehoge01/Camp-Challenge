<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

//課題1 9を入力
int num1=2;
switch(num1){
	case 1:
	out.print("one"+"<br>");
	break;
	case 2:
	out.print("two"+"<br>");
	break;
	default:
	out.print("想定外"+"<br>");
	break;
}

//課題2 Aを入力
char input=('あ');
switch(input){
	case 'A':
	out.print("英語"+"<br>");
	break;
	case 'あ':
	out.print("日本語"+"<br>");
	break;
}
%>