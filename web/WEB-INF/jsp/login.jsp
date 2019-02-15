<%-- 
    Document   : login
    Created on : 2018/01/15, 14:24:15
    Author     : g16910hm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <img src="/AD171011/image/horo_line2_yellow.png">
        <title>ログイン</title>
    </head>
    <body>
        <form action="/AD171011/LoginServlet" method="post">
            ユーザーID:<input type="text" name="userId"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
        </form>
         <img src="/AD171011/image/ballon_flower.png" weight="250" height="280">
    </body>
</html>
