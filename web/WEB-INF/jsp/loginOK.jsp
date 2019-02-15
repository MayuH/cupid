<%-- 
    Document   : loginOK
    Created on : 2018/01/15, 14:26:12
    Author     : g16910hm
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Login"%>
<%@page import="dao.UsersDAO"%>
<%@page import="model.Users"%>
<%
    Login loginUser = (Login) session.getAttribute("loginUser");
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
   
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン完了</title>
    </head>
    <body>
         <img src="/AD171011/image/star.png">
         <h3><p>ようこそ<%= name %>さん!</p></h3>
        <a href="/AD171011/WelcomeServlet">トップへ</a>
        <a href="/AD171011/MenuServlet">メニュ―へ</a>
         <img src="/AD171011/image/bouquet.png" weight="250" height="280">
    </body>
</html>

