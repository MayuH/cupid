<%-- 
    Document   : new
    Created on : 2018/01/15, 18:08:41
    Author     : g16910hm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録</title>
        
        <style type="text/css">
            textarea{
                width: 250px;
                height: 10em;
            }
        </style>
    </head>
    <body>
         <img src="/AD171011/image/flower.png">
        <h1>会員登録</h1>
        <form action="/AD171011/NewServlet" method="post">
            名前:<input type="text" name="name"><br>
            パスワード:<input type="password" name="pass"><br>
            年齢:<input type="number" name="age"><br>
            趣味:<input type="text" name="hobby"><br>
            職業:<input type="text" name="job"><br>
            性別:
            男<input type="radio" name="sex" value="0">
            女<input type="radio" name="sex" value="1"><br>
            好みのタイプ:<input type="text" name="type"><br>
            ひとこと:
            <textarea name="msg" cols="30" rows="10"></textarea><br>
            興味のある分野:<br>
            
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
            
            
            <input type="submit" value="登録">
        </form>
    </body>
</html>
