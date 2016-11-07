package kadai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Y.Sasa
 */
@WebServlet(urlPatterns = {"/kadaiC"})
public class kadaiC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        final String fw = "/WEB-INF/jsp/Form.jsp";
        try {
            request.setCharacterEncoding("UTF-8");
            //課題８
            if (request.getParameter("8IsntEmpty") != null) {
                String result8 = "";
                String k8 = request.getParameter("k8");
                result8 = kadaiM.kadai8(k8);
                //課題８RequestScope
                JB jb8 = new JB();
                jb8.setResult(result8);
                request.setAttribute("JB8", jb8);
            }
            //課題９
            if (request.getParameter("9IsntEmpty") != null) {
                String result9 = "";
                String profilesID9 = request.getParameter("profilesID");
                String name9 = request.getParameter("name");
                String tell9 = request.getParameter("tell");
                String age9 = request.getParameter("age");
                String birthday9 = request.getParameter("birthday");
                result9 = kadaiM.kadai9(profilesID9, name9, tell9, age9, birthday9);
                //課題９RequestScope
                JB jb9 = new JB();
                jb9.setResult(result9);
                request.setAttribute("JB9", jb9);
            }
            //課題１０
            if (request.getParameter("10IsntEmpty") != null) {
                String result10 = "";
                String profilesID10 = request.getParameter("k10");
                result10 = kadaiM.kadai10(profilesID10);
                //課題１０RequestScope
                JB jb10 = new JB();
                jb10.setResult(result10);
                request.setAttribute("JB10", jb10);
            }
            //課題１１
            if (request.getParameter("11IsntEmpty") != null) {
                String result11 = "";
                String profilesID11 = request.getParameter("profilesID");
                String name11 = request.getParameter("name");
                String tell11 = request.getParameter("tell");
                String age11 = request.getParameter("age");
                String birthday11 = request.getParameter("birthday");
                result11 = kadaiM.kadai11(profilesID11, name11, tell11, age11, birthday11);
                //課題１１RequestScope
                JB jb11 = new JB();
                jb11.setResult(result11);
                request.setAttribute("JB11", jb11);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet kadaiC</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet kadaiC at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            //Forward
            RequestDispatcher rd = request.getRequestDispatcher(fw);
            rd.forward(request, response);

        } catch (Exception e) {
            out.print(e.toString());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
