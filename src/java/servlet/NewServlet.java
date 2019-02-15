/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BBB;
import model.Detail;
import model.PostBbb;

import model.PostDetail;
import model.PostUsersLogic;
import model.User;

/**
 *
 * @author g16910hm
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

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
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/new.jsp");
        dispatcher.forward(request, response);
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
        
        //リクエストパラメーターの取得
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String age = request.getParameter("age");
        String hobby = request.getParameter("hobby");
        String job = request.getParameter("job");
        String sex = request.getParameter("sex");
        String type = request.getParameter("type");
        String msg = request.getParameter("msg");
        String[] b=new String[20];
        /*for(int i=0; i<20; i++) b[i]="0";
        String aaa = "1";
        String aa;*/
        
        b[0] = request.getParameter("b1");
        
        b[1] = request.getParameter("b2");
        
        b[2] = request.getParameter("b3");
        b[3] = request.getParameter("b4");
        b[4] = request.getParameter("b5");
        b[5] = request.getParameter("b6");
        b[6] = request.getParameter("b7");
        b[7] = request.getParameter("b8");
        b[8] = request.getParameter("b9");
        b[9] = request.getParameter("b10");
        b[10] = request.getParameter("b11");
        b[11] = request.getParameter("b12");
        b[12] = request.getParameter("b13");
        b[13] = request.getParameter("b14");
        b[14] = request.getParameter("b15");
        b[15] = request.getParameter("b16");
        b[16] = request.getParameter("b17");
        b[17] = request.getParameter("b18");
        b[18] = request.getParameter("b19");
        b[19] = request.getParameter("b20");
        for(int i=0; i<20; i++){
            if(b[i]==null)b[i]="0";
            //System.out.println(b[i]);
        }
        
        
        //入力値チェック
        if(name.length() != 0 && pass.length() != 0){
            User user = new User(name,pass);
            PostUsersLogic postUsersLogic = new PostUsersLogic();
            postUsersLogic.execute(user);
        }
        if(age.length() != 0 && hobby.length() != 0 && job.length() != 0 && sex.length() != 0 && type.length() != 0 && msg.length() != 0){
            Detail detail = new Detail(age,hobby,job,sex,type,msg);
            PostDetail postDetail = new PostDetail();
            postDetail.execute(detail);
            
        }
        //if(true){
            BBB bbb = new BBB(b);
            PostBbb postBbb = new PostBbb();
            postBbb.execute(bbb);
        //}
        //Userインスタンスの生成
        User user = new User(name,pass);
        
        //セッションスコープにIDを保存
        HttpSession session = request.getSession();
            session.setAttribute("loginUser",user);
            
        RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/newOK.jsp");
        dispatcher.forward(request, response);
        
        
        
        
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
