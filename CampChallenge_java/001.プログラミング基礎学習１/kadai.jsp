<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

//�ۑ�1
out.print("Hello world.<br>");

//�ۑ�2
out.print("groove"+"-"+"gear<br>");

//�ۑ�3
out.print("My Github Profile is <a href=\"https://github.com/hogehoge01\">here</a><br>");

//�ۑ�4,5
final int num1=460;
out.print((num1+150)+"<br>");
out.print((1000-num1)+"<br>");
out.print((num1*10)+"<br>");
out.print((num1/20)+"<br>"+"<br>");
	int num2=1500;
	out.print((++num2+1500)+"<br>");	//(1+1500)+1500(++num2������)
	out.print((num2++-1500)+"<br>");	//(1500+1)-1500
	out.print((num2*100)+"<br>");			//(1501+1)*100	(num2++�̏���)
	out.print((num2/100)+"<br>");			//1502/100
	out.print((num2%100)+"<br>"+"<br>");	//...2

//�ۑ�6
int num3=1;
if(num3==1){
out.print("�P�ł��I");
}
if(num3==2){
out.print("�v���O���~���O�L�����v�I");
}
else{
out.print("���̑��ł��I");
}

num3=2;
if(num3==1){
out.print("�P�ł��I");
}
if(num3==2){
out.print("�v���O���~���O�L�����v�I");
}
else{
out.print("���̑��ł��I");
}

num3=10;
if(num3==1){
out.print("�P�ł��I");
}
if(num3==2){
out.print("�v���O���~���O�L�����v�I");
}
else{
out.print("���̑��ł��I");
}

%>
