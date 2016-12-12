/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "LoginCheck", urlPatterns = {"/LoginCheck"})
public class LoginCheck extends HttpServlet {

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
            //送信元htmlの文字コードはUTF-8
            request.setCharacterEncoding("UTF-8");
            //フォームからメールアドレスとパスワードを取得
            String mailAddress=request.getParameter("mailAddress");
            String password=request.getParameter("password");
            //DAOクラスのインスタンスを生成
            UserDataDAO dao=new UserDataDAO();
            //メールアドレス、パスワードがあっているかどうかのboolean
            boolean chkMail=false;
            boolean chkPassword=false;
            boolean isLogin=false;
            //メールアドレス、パスワードが間違っている場合のメッセージ
            String loginMessage="";
            //メールアドレスがあっているかどうかチェック
            if(dao.checkMail(mailAddress)){
                chkMail=true;
            }else{
                loginMessage="メールアドレスが間違っています<br>";
            }
            //パスワードがあっているかどうかチェック
            if(dao.checkPassword(password)){
                chkPassword=true; 
            }else{
                loginMessage+="パスワードが間違っています<br>";
            }
            //ログイン状態にしていいかどうかのチェック
            if(chkMail&&chkPassword){
                isLogin=true;
                loginMessage="ログイン成功<br>";
                //ここでユーザー名を取得してセッションに突っ込む必要がある
            }else{
                isLogin=false;
            }
            //セッションにログイン可否を格納
            HttpSession session = request.getSession();
            session.setAttribute("isLogin",isLogin);
            //リクエストスコープにメッセージを格納
            request.setAttribute("message", loginMessage);
            //ログイン成功、top.jspへフォワード
            if(isLogin){
                request.getRequestDispatcher("/top.jsp").forward(request, response);
            }else{
                //ログイン失敗、login.jspへフォワード
                request.getRequestDispatcher("/top.jsp").forward(request, response);
            }
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }finally {
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
