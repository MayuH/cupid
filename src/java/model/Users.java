/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author g16910hm
 */
public class Users implements Serializable{
    private String userId;
    private String name;
    private String pass;
    
    public Users(){}
    public Users(String userId, String name,String pass){
        this.userId=userId;
        this.name=name;
        this.pass=pass;
    }
    public String getUserId(){return userId;}
    public String getName(){return name;}
    public String getPass(){return pass;}
    
    
    
}
