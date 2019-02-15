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
import model.BBB;
import model.BBBs;
import model.Detail;
import model.Details;

/**
 *
 * @author g16910hm
 */
public class BbbDAO {
    private final String DRIVER_NAME = ("org.apache.derby.jdbc.ClientDriver");
    private final String JDBC_URL ="jdbc:derby://localhost:1527/db1011";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    String userId;
    public List<BBBs> findAll(){
        Connection conn = null;
        List<BBBs> bbbsList = new ArrayList<BBBs>();
        try{
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            //SELECT文の準備
            String sql =
                    "SELECT ID,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,b14,B15,B16,B17,B18,B19,B20 FROM BBB ORDER BY ID DESC";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            //SELECTを実行
            ResultSet rs = pStmt.executeQuery();
            
            //SELECT文の結果をArrayListに格納
            while(rs.next()){
                String id = rs.getString("ID");
                String b[] = new String[20];
                b[0] = rs.getString("b1");
        b[1] = rs.getString("b2");
        b[2] = rs.getString("b3");
        b[3] = rs.getString("b4");
        b[4] = rs.getString("b5");
        b[5] = rs.getString("b6");
        b[6] = rs.getString("b7");
        b[7] = rs.getString("b8");
        b[8] = rs.getString("b9");
        b[9] = rs.getString("b10");
        b[10] = rs.getString("b11");
        b[11] = rs.getString("b12");
        b[12] = rs.getString("b13");
        b[13] = rs.getString("b14");
        b[14] = rs.getString("b15");
        b[15] = rs.getString("b16");
        b[16] = rs.getString("b17");
        b[17] = rs.getString("b18");
        b[18] = rs.getString("b19");
        b[19] = rs.getString("b20");
                BBBs bbbs = new BBBs(id,b);
                bbbsList.add(bbbs);
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
        return bbbsList;
    }
    public boolean create(BBB bbb){
        Connection conn = null;
        try{
            //DBに接続
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            //INSERT文の準備
            String sql = "INSERT INTO BBB(B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,b14,B15,B16,B17,B18,B19,B20) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            //INSERT文中の「？」に使用する値を設定しSQLを完成
            //pStmt.setString(1,detail.getUserId());
            String[] b = new String[20];
            b=bbb.getB();
            pStmt.setString(1,b[0]);
            pStmt.setString(2,b[1]);
            pStmt.setString(3,b[2]);
            pStmt.setString(4,b[3]);
            pStmt.setString(5,b[4]);
            pStmt.setString(6,b[5]);
            pStmt.setString(7,b[6]);
            pStmt.setString(8,b[7]);
            pStmt.setString(9,b[8]);
            pStmt.setString(10,b[9]);
            pStmt.setString(11,b[10]);
            pStmt.setString(12,b[11]);
            pStmt.setString(13,b[12]);
            pStmt.setString(14,b[13]);
            pStmt.setString(15,b[14]);
            pStmt.setString(16,b[15]);
            pStmt.setString(17,b[16]);
            pStmt.setString(18,b[17]);
            pStmt.setString(19,b[18]);
            pStmt.setString(20,b[19]);
            
            
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

    

