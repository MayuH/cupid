/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author g16910hm
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Detail;
import model.Users;
import model.Login;
import model.User;
//import model.Mutter;

/**
 *
 * @author g16910hm
 */
public class UsersDAO {
    private final String DRIVER_NAME = ("org.apache.derby.jdbc.ClientDriver");
    private final String JDBC_URL ="jdbc:derby://localhost:1527/db1011";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    String userId;
    public Users findByLogin(Login login){
        Connection conn = null;
        Users users = null;
        //Mutter mutter = null;
        try{
            //JDBCドライバを読み込む
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/db1011";
            
            //データベースに接続
            conn=DriverManager.getConnection(
            driverURL, "db", "db");
            
            //SELECT文を準備
            String sql = "SELECT ID,NAME,PASS FROM USERS WHERE ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login.getUserId());
            pStmt.setString(2, login.getPass());

            //SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();
            
            //一致したユーザーが存在した場合そのユーザーが表すusersインスタンスを生成
            if(rs.next()){
                //結果表からデータを取得
                userId = rs.getString("ID");
                String pass = rs.getString("PASS");
                
                String name = rs.getString("NAME");
                
                
                users = new Users(userId,name,pass);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        
        }finally{
            //データベースを切断
            if(conn != null){
                try{
                    conn.close();
                
                }catch(SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        //三方ユーザーまたはnullを返す
        return users;
    }
    public boolean create(User user){
        Connection conn = null;
        try{
            //DBに接続
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            //INSERT文の準備
            String sql = "INSERT INTO USERS(NAME,PASS) VALUES(?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            //INSERT文中の「？」に使用する値を設定しSQLを完成
            //pStmt.setString(1,users.getUserId());
            pStmt.setString(1,user.getName());
            pStmt.setString(2,user.getPass());
            
            //INSERT文を実行
            int result = pStmt.executeUpdate();
            
            if(result != 1){
                return false;}
            
            }catch(SQLException e){
                e.printStackTrace();
                return false;
        }finally{
            //データベース切断
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    
        
    }
    
    public List<Users> findAll(){
        
        Connection conn = null;
        List<Users> userList = new ArrayList<Users>();
        //String[][] userList = new String[10000][10000];
        
        try{
            
            //JDBCドライバを読み込み
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //データベースへ接続
            conn = DriverManager.getConnection(        
            "jdbc:derby://localhost:1527/db1011", "db", "db");
            
            //SELECT文を準備
            String sql = "SELECT ID, NAME, PASS FROM USERS";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            //SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();
            
            //結果表に格納されたレコードの内容を
            //Employeeインスタンスにせていし、ArrayListインスタンスに追加
            while(rs.next()){
                String userId=rs.getString("ID");
                String name = rs.getString("NAME");
                String pass = rs.getString("PASS");
                Users users = new Users(userId,name,pass);
                userList.add(users);
            }
        }catch(SQLException e){
           
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }finally{
            //データベース切断
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }
}

