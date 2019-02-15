<%-- 
    Document   : chose
    Created on : 2018/01/17, 19:06:51
    Author     : g16910hm
--%>

<%@page import="model.Users"%>
<%@page import="dao.UsersDAO"%>
<%@page import="model.Login"%>
<%@page import="model.BBBs"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbbDAO"%>
<%@page import="model.BBB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Login loginUser = (Login) session.getAttribute("loginUser");
    String id1 = loginUser.getUserId();
    BbbDAO bbbDAO = new BbbDAO();
    //List<BBBs> bbbList = BbbDAO.findAll();
    /*String id1 = loginBbb.getUserId();
    int ID1 = Integer.parseInt(id1);
    String name="";
    for(Users user1 : userList){
        String id2=user1.getUserId();
        int ID2 = Integer.parseInt(id2);
         //System.out.println("id1="+id1);
        //System.out.println("id2="+id2);
        if(ID1==ID2) {
            name=user1.getName(); 
        /*System.out.println("ok");
    }else System.out.println("no");
    }*/
    
   
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>分野選択</title>
    </head>
    <body>
         <img src="/AD171011/image/clover.png">
        <h1>好きな分野を選んでください。</h1><br>
         <form action="/AD171011/SearchServlet" method="post">   
            <input type="checkbox" name="b1" value="1">料理<br>
            <input type="checkbox" name="b2" value="1">ペット<br>
            <input type="checkbox" name="b3" value="1">手芸<br>
            <input type="checkbox" name="b4" value="1">乗り物<br>
            <input type="checkbox" name="b5" value="1">スポーツ<br>
            <input type="checkbox" name="b6" value="1">ミリタリー<br>
            <input type="checkbox" name="b7" value="1">ゲーム<br>
            <input type="checkbox" name="b8" value="1">写真<br>
            <input type="checkbox" name="b9" value="1">映画<br>
            <input type="checkbox" name="b10" value="1">アニメ<br>
            <input type="checkbox" name="b11" value="1">旅行<br>
            <input type="checkbox" name="b12" value="1">機械<br>
            <input type="checkbox" name="b13" value="1">グルメ<br>
            <input type="checkbox" name="b14" value="1">読書<br>
            <input type="checkbox" name="b15" value="1">音楽<br>
            <input type="checkbox" name="b16" value="1">お笑い<br>
            <input type="checkbox" name="b17" value="1">ファッション<br>
            <input type="checkbox" name="b18" value="1">釣り<br>
            <input type="checkbox" name="b19" value="1">美術<br>
            <input type="checkbox" name="b20" value="1">ボランティア<br>
            <input type="submit" value="探す">
         </form>
         <img src="/AD171011/image/12_8bu_onpu_renkou.png" weight="150" height="150">
    </body>
</html>
