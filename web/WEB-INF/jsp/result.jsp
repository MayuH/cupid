<%-- 
    Document   : result
    Created on : 2018/01/17, 19:31:36
    Author     : g16910hm
--%>

<%@page import="model.Users"%>
<%@page import="dao.UsersDAO"%>
<%@page import="model.Login"%>
<%@page import="model.Search"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Details"%>
<%@page import="dao.DetailDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbbDAO"%>
<%@page import="model.BBB"%>
<%@page import="model.BBBs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    BBB bbbUser = (BBB) session.getAttribute("bbbUser");//選んだやつ
    Login loginUser = (Login) session.getAttribute("loginUser");
    //System.out.println(loginUser.getUserId());
    //System.out.println("new");
    BbbDAO bbbDAO = new BbbDAO();
    List<BBBs> bbbsList = bbbDAO.findAll();//すべてのBBB
    DetailDAO detailDAO = new DetailDAO();
    List<Details> detailsList = detailDAO.findAll();//すべてのdetail
    //List<Details> dList = detailDAO.findAll();
    List<Details> detailList=new ArrayList<Details>();
    UsersDAO usersDAO = new UsersDAO();
    List<Users> usersList = usersDAO.findAll();//すべてのユーザー
    Details userdetail = new Details();
    
    for(Details det1 : detailsList){//ユーザーのdetailを取得
        String ID1 = loginUser.getUserId();
        String ID2 = det1.getUserId();
        
        if(ID1.equals(ID2)) {userdetail=det1;break;}
    }
    String gender1 = userdetail.getSex();
    
     String[] id = new String[1000];
     String[] b = bbbUser.getB();//調べたい分野
     
     int a = 0;
     int a2=0;
     int[] a3=new int[1000];
    for(BBBs bbb1 : bbbsList){
        String[] c=bbb1.getB();
        //String aaaa=bbb1.getUserId();
        for(int i=0; i<20; i++){ //調べたい分野bが選択してあれば一致するcを探す
            //System.out.println(c[i]);
            if(!(b[i].equals("1"))){/*System.out.println("by"+i+" "+b[i]+" "+c[i]+" "+aaaa);*/continue;}//0なら飛ばす
            else if(c[i].equals("1")){ id[a]=bbb1.getUserId();a++;}//分野選んでるbbbのIDを全取得
        
        }
        
        }
    
    
    String gender2="0";
    String[] iid=new String[a-1];
    String nid = "0";
    int bb=0;
    
    for(Details dets : detailsList){
        
            gender2=dets.getSex();
            
            nid=dets.getUserId();
            
            if(gender2.equals(gender1)){
                for(int j=0; j<=a-1; j++){
                    
                    if(!(id[j].equals(nid))){continue;}
                    id[j]="-1";
                    
                    
                }
            }
    }
    //System.out.println(iid.length);
    for(int i=0; i<a-1; i++){
        if(!(id[i].equals("-1"))){iid[bb]=id[i];bb++;
        //System.out.println(bb);
        }
        
    }//gender省いたidとその個数bb
    String[] id2=new String[bb-1];
    
    for(int i=0; i<=bb-1; i++){//i番目のidがすでにiidに入っているか確認し、入っていなければiidにidを格納。この際a3[]で回数を数える
        for(int j=0; j<bb-1; j++){//j番目のiidがi番目のidと同じなら
            
            if(iid[i] == id2[j]){a3[j]++;id[i]="0";}
        }
        if(!(id[i].equals("0"))){
        id2[a2]=iid[i];a3[a2]++;a2++;//a3にかぶった個数、id2はID(かぶらない)を入れる
        }else continue;
    }
    
    
    for(Details det : detailsList){
        String ID1=det.getUserId();
        for(int i=0; i<id2.length; i++){
            if(ID1.equals(id2[i])) detailList.add(det);//id2をつかってユーザーの情報を取り出しdetailListに格納
        }
    }
        
        String[] idS = new String[id2.length];//最終的なID
        //List<Details> detailListS=new ArrayList<Details>();//最終的なdetail
        int a4=0;
        for(int i=20; i>0; i--){
            for(int j=0; j<a3.length; j++){
                if(a3[j]==i){
                    idS[a4]=id2[j];
                    //System.out.println(idS[a4]);
                    /*detailListS.add(detailList.get(j));*/a4++;
                }
            }
        }
        //System.out.println(idS.length);
        String[] name = new String[idS.length];//名前
        String[] age = new String[idS.length];
        String[] hobby = new String[idS.length];
        String[] job = new String[idS.length];
        String[] type = new String[idS.length];
        String[] speech = new String[idS.length];
        
        int a5=0;
        int a6=0;
        for(int i=0; i<idS.length; i++){
            for(Users user : usersList){
                String idu = user.getUserId();
                if(idu.equals(idS[i])){
                    name[a5]=user.getName();
                    
                    a5++;
                }
            }
            for(Details dett : detailsList){
                String idd = dett.getUserId();
                if(idd.equals(idS[i])){
                    age[a6]=dett.getAge();
                    hobby[a6]=dett.getHobby();
                    job[a6]=dett.getJob();
                    type[a6]=dett.getType();
                    speech[a6]=dett.getSpeech();
                    a6++;
                }
            }
        }
        String[] name1 = new String[a6];//名前
        String[] age1 = new String[a6];
        String[] hobby1 = new String[a6];
        String[] job1 = new String[a6];
        String[] type1 = new String[a6];
        String[] speech1 = new String[a6];
        for(int i=0; i<a6; i++){
            name1[i]=name[i];
            age1[i]=age[i];
            hobby1[i]=hobby[i];
            job1[i]=job[i];
            type1[i]=type[i];
            speech1[i]=speech[i];
        }
        
            
        
    
   
    %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
    </head>
    <body>
         <img src="/AD171011/image/flower.png">
        <h1>こんなユーザーが見つかりました！</h1>
        <a href="/AD171011/MenuServlet">メニュ―へ</a>
        <a href="/AD171011/LogoutServlet">ログアウト</a>
        <% for(int i=0; i<name1.length; i++){ 
        %> 
        <h2><%= name1[i]%></h2>
        年齢：<%= age1[i]%><br>
        趣味：<%= hobby1[i]%><br>
        職業：<%= job1[i]%><br>
        好みのタイプ：<%= type1[i]%><br>
        ひとこと：<%= speech1[i]%><br>
        <br>
        <% } %>
        
    </body>
</html>
