<%-- 
    Document   : mutter
    Created on : 2018/01/19, 18:53:01
    Author     : g16910hm
--%>

<%@page import="model.Users"%>
<%@page import="dao.UsersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User,model.GetMutterListLogic,model.Login,model.Mutter,java.util.List" %>
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
    //セッションスコープに保存されたユーザー情報を取得
    GetMutterListLogic getMutterListLogic =new GetMutterListLogic();
    
    
    //アプリケーションスコープに保存されたつぶやきリストを取得
    List<Mutter> mutterList = getMutterListLogic.execute();
    request.setAttribute("mutterList",mutterList);
    String errorMsg=(String) request.getAttribute("errorMsg");
    //リクエストスコープに保存されたエラーを取得
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>掲示板</title>
    </head>
    <body>
         <img src="/AD171011/image/tori_saeduri_sing_line.png" >
        <h1>掲示板</h1>
        <p><%= name %>さん、ログイン中
            <a href="/AD171011/LogoutServlet">ログアウト</a>
            <a href="/AD171011/MenuServlet">メニュ―へ</a>
        </p>
        <p><a href="/AD171011/MutterServlet">更新</a></p>
        <form action="/AD171011/MutterServlet" method="post">
            <input type="text" name="text">
            <input type="submit" value="つぶやく">
        </form>
        <c:if test="${not empty errorMsg}">
            <p>${errorMsg}</p>
        </c:if>
        <c:forEach var="mutter" items="${mutterList}">
            <p><c:out value="${mutter.userName}"/>:
                <c:out value="${mutter.text}"/>
                </p>
        </c:forEach>
    </body>
</html>
