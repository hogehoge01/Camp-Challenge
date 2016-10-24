package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public final class dataKadai1_005f4_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("         <form action=\"dataKadai1_4.jsp\" method=\"post\">\n");
      out.write("             名前<input type=\"text\" name=\"txtName\"><br>\n");
      out.write("             性別 男性<input type=\"radio\" name=\"rdo\" value=\"男性\">女性<input type=\"radio\" name=\"rdo\" value=\"女性\"><br>\n");
      out.write("             趣味<textarea name=\"mulTxt\"></textarea><br>\n");
      out.write("             <input type=\"submit\" value=\"送信\">\n");
      out.write("         </form>\n");
      out.write("         <br>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            request.setCharacterEncoding("UTF-8");
            String txtName = request.getParameter("txtName");
            String rdo = request.getParameter("rdo");
            String mulTxt = request.getParameter("mulTxt");
            //kadai2
            if(txtName!=""&&txtName!=null){
                out.print("名前 "+txtName+"<br>");
            }else{
                out.print("＊名前を入力してください"+"<br>");
            }
            if(rdo!=null&&rdo!=null){
                out.print("性別 "+rdo+"<br>");
            }else{
                out.print("＊性別にチェックを入れてください"+"<br>");
            }
            if(mulTxt!=""&&mulTxt!=null){
                out.print("趣味 "+mulTxt+"<br>");
            }else{
                out.print("＊趣味を入力してください"+"<br>");
            }
        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            //初回の訪問
            Date currentTime=new Date();
            Cookie cookie=new Cookie("lastAccessC",currentTime.toString());
            response.addCookie(cookie);
            //次の訪問
            Cookie cs[] = request.getCookies();
            if (cs != null) {
                for (int i=0; i<cs.length; i++) {
                    if (cs[i].getName().equals("lastAccessC")) {
                        out.print("最後のログインは、"+cs[i].getValue()+"です。(Cookie)");
                        break;
                    }
                }
            }

        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            //初回の訪問
            HttpSession hs=request.getSession(true);
            if(hs.getAttribute("lastAccessS")==null){
                out.print("Sessionはnullです");
            }else{
                out.print("最後のログインは、"+hs.getAttribute("lastAccessS")+"です。(Session)");
            }
            hs.setAttribute("lastAccessS",currentTime.toString());
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
