/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GetMutterListLogic;
import model.Login;
import model.Mutter;
import model.PostMutterLogic;
import model.Users;

/**
 *
 * @author g16910hm
 */
@WebServlet(name = "MutterServlet", urlPatterns = {"/MutterServlet"})
public class MutterServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MutterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MutterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        //つぶやきリストを取得して、リクエストスコープに保存
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList",mutterList);
        
        
        
        
        
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/mutter.jsp");
            dispatcher.forward(request,response);
        
        
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
        //processRequest(request, response);
        //リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");
        
        //入力値チェック
        if(text != null && text.length() != 0){
            //アプリケーションスコープに保存されたつぶやきリストを取得
            ServletContext application = this.getServletContext();
            List<Mutter> mutterList =
                    (List<Mutter>) application.getAttribute("mutterList");
            
            //セッションスコープに保存されたユーザー情報を取得
            HttpSession session = request.getSession();
            Login loginUser = (Login) session.getAttribute("loginUser");
            
            //ログインしているユーザーの名前を取得
            UsersDAO usersDAO = new UsersDAO();
            List<Users> userList = usersDAO.findAll();
            String id1 = loginUser.getUserId();
            int ID1 = Integer.parseInt(id1);
            String name="";
            for(Users user1 : userList){
                String id2=user1.getUserId();
                int ID2 = Integer.parseInt(id2);
                if(ID1==ID2) {
                    name=user1.getName(); 
        
                }
            }
            
            
            //つぶやきをつぶやきリストに追加
            Mutter mutter = new Mutter(name,text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);
            
            
        }else{
            //エラーメッセージをリクエストスコープに保存
            request.setAttribute("errorMsg","何も入力されていません");
        }
        
        //つぶやきリストを取得して、リクエストスコープに保存
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList",mutterList);
        //掲示板画面にフォワード
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/jsp/mutter.jsp");
        dispatcher.forward(request,response);
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
