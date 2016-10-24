package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.Cookie;
import java.util.ArrayList;

public final class datakadai5_005f6_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <form action=\"datakadai5_6.jsp\" method=\"post\">\n");
      out.write("             名前<input type=\"text\" name=\"txtName\"><br>\n");
      out.write("             性別 男性<input type=\"radio\" name=\"rdo\" value=\"M\">女性<input type=\"radio\" name=\"rdo\" value=\"F\"><br>\n");
      out.write("             趣味<textarea name=\"mulTxt\"></textarea><br>\n");
      out.write("             <input type=\"submit\" value=\"送信\">\n");
      out.write("         </form>\n");
      out.write("        ");

            request.setCharacterEncoding("UTF-8");
            String txtName = request.getParameter("txtName");
            String rdo = request.getParameter("rdo");
            String mulTxt = request.getParameter("mulTxt");
            
            Cookie cookie1=new Cookie("txtName",txtName);
            Cookie cookie2=new Cookie("rdo",rdo);
            Cookie cookie3=new Cookie("mulTxt",mulTxt);
            
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);
            
            Cookie cs1[] = request.getCookies();
            if (cs1 != null) {
                for (int i=0; i<cs1.length; i++) {
                    if (cs1[i].getName().equals("txtName")) {
                        out.print("前回の入力:<br>"+cs1[i].getValue()+"<br>");
                    }
                     if (cs1[i].getName().equals("rdo")) {
                        out.print(cs1[i].getValue()+"<br>");
                    }
                      if (cs1[i].getName().equals("mulTxt")) {
                        out.print(cs1[i].getValue()+"<br>");
                        break;
                    }
                }
            }
            
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
