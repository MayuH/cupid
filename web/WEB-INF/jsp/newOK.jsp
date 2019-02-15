<%-- 
    Document   : newOK
    Created on : 2018/01/15, 18:20:01
    Author     : g16910hm
--%>

<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Login"%>
<%@page import="dao.UsersDAO"%>
<%@page import="model.Users"%>
<%
    User loginUser = (User) session.getAttribute("loginUser");
    UsersDAO usersDAO = new UsersDAO();
    List<Users> userList = usersDAO.findAll();
    String name1 = loginUser.getName();
    String pass1 = loginUser.getPass();
    
    String id1="";
    for(Users user1 : userList){
        String name2=user1.getName();
        String pass2 = user1.getPass();
        
        if(name2.equals(name1) && pass2.equals(pass1)) {
            id1=user1.getUserId(); 
        
        }
    }
   
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録完了</title>
    </head>
    <body>
        <h1>
        登録完了しました！</h1>
        <h1>あなたのIDは<%= id1%></h1>
        <a href="/AD171011/WelcomeServlet">トップへ</a>
        
            
    </body>
</html>
