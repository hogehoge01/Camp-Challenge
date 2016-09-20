<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

//課題10
// http://localhost:8080/camp/java2kadai10.jsp?req=

String req=request.getParameter("req");
int x=Integer.parseInt(req);

out.print("元の値:"+x+"<br>");
out.print("1桁の素因数:");

if(x%2==0){
	while(x%2==0){
		out.print(2+" ");
		x/=2;
	}
}
if(x%3==0){
	while(x%3==0){
		out.print(3+" ");
		x/=3;
	}
}

if(x%5==0){
	while(x%5==0){
		out.print(5+" ");
		x/=5;
	}
}
if(x%7==0){
	while(x%7==0){
		out.print(7+" ");
		x/=7;
	}
}

if(x!=1){
	out.print("<br>"+"その他");
}

%>