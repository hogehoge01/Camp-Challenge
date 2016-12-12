/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import base.YahooAPIManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javaBeans.ItemDataBeans;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Y.Sasa
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

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
        try {
            //文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            //検索キーワードを取得
            String search=request.getParameter("search");
            if(search==null||search.length()==0){
                //フォームが空のとき
                request.setAttribute("searchIsEmpty",true);
            }else{
                //JSONを取得
                String json=YahooAPIManager.getJson(search);
                //JSONをパース
                ArrayList<ItemDataBeans> idb=YahooAPIManager.ParseJSON(json);
                //検索キーワードをスコープに保存
                request.setAttribute("search",search);
                //検索結果数をスコープに保存
                int total=YahooAPIManager.getTotalResultNum();
                request.setAttribute("total",total);
                //セッションにidb(検索結果が入っているArrayListを格納)
                HttpSession session=request.getSession();
                session.setAttribute("idb",idb);
                //検索結果が空かどうかのbooleanをスコープに保存
                request.setAttribute("searchIsEmpty",false);
            }
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
