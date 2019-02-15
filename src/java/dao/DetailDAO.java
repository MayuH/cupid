/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Detail;
import model.Details;

/**
 *
 * @author g16910hm
 */

public class DetailDAO {
    private final String DRIVER_NAME = ("org.apache.derby.jdbc.ClientDriver");
    private final String JDBC_URL ="jdbc:derby://localhost:1527/db1011";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    String userId;
    public List<Details> findAll(){
        Connection conn = null;
        List<Details> detailsList = new ArrayList<Details>();
        try{
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            //SELECT文の準備
            String sql =
                    "SELECT ID,AGE,HOBBY,JOB,SEX,TYPE,SPEECH FROM DETAIL ORDER BY ID DESC";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            //SELECTを実行
            ResultSet rs = pStmt.executeQuery();
            
            //SELECT文の結果をArrayListに格納
            while(rs.next()){
                String id = rs.getString("ID");
                String age = rs.getString("AGE");
                String hobby = rs.getString("HOBBY");
                String job = rs.getString("JOB");
                String sex = rs.getString("SEX");
                String type = rs.getString("TYPE");
                String speech = rs.getString("SPEECH");
                Details details = new Details(id,age,hobby,job,sex,type,speech);
                detailsList.add(details);
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
        return detailsList;
    }
    public boolean create(Detail detail){
        Connection conn = null;
        try{
            //DBに接続
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            //INSERT文の準備
            String sql = "INSERT INTO DETAIL(AGE,HOBBY,JOB,SEX,TYPE,SPEECH) VALUES(?,?,?,?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            //INSERT文中の「？」に使用する値を設定しSQLを完成
            //pStmt.setString(1,detail.getUserId());
            pStmt.setString(1,detail.getAge());
            pStmt.setString(2,detail.getHobby());
            pStmt.setString(3,detail.getJob());
            pStmt.setString(4,detail.getSex());
            pStmt.setString(5,detail.getType());
            pStmt.setString(6,detail.getSpeech());
            
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
}
